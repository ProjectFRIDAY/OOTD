package OOTD.demo.auth.service;


import OOTD.demo.auth.RefreshToken;
import OOTD.demo.auth.TokenProvider;
import OOTD.demo.auth.dto.AccessTokenRes;
import OOTD.demo.auth.dto.CreateUserReq;
import OOTD.demo.auth.dto.LoginReq;
import OOTD.demo.auth.dto.LoginRes;
import OOTD.demo.auth.filter.JwtFilter;
import OOTD.demo.auth.repository.RefreshTokenRepository;
import OOTD.demo.user.User;
import OOTD.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.time.LocalDateTime;
import java.util.Optional;

import static OOTD.demo.auth.RefreshToken.createRefreshToken;

/**
 * User 관련 서비스 클래스입니다.
 *
 * @author CHO Min Ho
 */
@Transactional
@RequiredArgsConstructor
@Service
@Slf4j
public class AuthService implements UserDetailsService {

    @Value("${jwt.refresh-token-validity-in-seconds}")
    private Long REFRESH_TOKEN_VALIDITY_IN_SECONDS;

    private final String ACCESS_TOKEN_PREFIX = "Bearer ";
    private final String REFRESH_TOKEN_PREFIX = "RefreshToken";
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final RefreshTokenRepository refreshTokenRepository;

    /**
     * 회원가입 메서드입니다.
     * @param dto 회원가입 정보
     * @return 생성된 User의 ID
     */
    public Long createUser(CreateUserReq dto) {

        String password = passwordEncoder.encode(dto.getPassword());
        return userRepository.save(User.createUser(dto.getEmail(), password, dto.getAccountName(),
                dto.getNickName(), dto.getUserBirth())).getId();

    }

    /**
     * 로그인 메서드입니다.
     * @param dto 로그인 정보
     * @param response HTTP Servlet response
     * @return 로그인 결과
     */
    public LoginRes login(LoginReq dto, HttpServletResponse response) {

        User member = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("해당 이메일을 가지는 사용자를 찾을 수 없습니다."));

        if (!passwordEncoder.matches(dto.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = tokenProvider.createToken(authentication);

        response.addHeader(JwtFilter.AUTHORIZATION_HEADER, ACCESS_TOKEN_PREFIX + accessToken);

        return new LoginRes(member.getId(), accessToken,
                refreshTokenRepository.save(createRefreshToken(member,
                        LocalDateTime.now().plusSeconds(REFRESH_TOKEN_VALIDITY_IN_SECONDS / 1000))).getRefreshToken());
    }

    /**
     * 현재 로그인된 사용자를 반환하는 메서드입니다.
     * @return 로그인된 사용자
     * @throws UsernameNotFoundException 세션에 저장된 이메일이 유효하지 않을 경우
     */
    public User getCurrentLoginUser() throws UsernameNotFoundException {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userEmail = ((UserDetails) principal).getUsername();

        return userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("해당 이메일을 가지는 사용자를 찾을 수 없습니다."));
    }

    /**
     * 로그아웃을 담당하는 메서드입니다.
     * @param request HTTP request
     */
    public void logout(HttpServletRequest request) {

        refreshTokenRepository.deleteByRefreshToken(request.getHeader(REFRESH_TOKEN_PREFIX));
    }

    public AccessTokenRes reissueAccessToken(HttpServletRequest request) {
        String token = getAccessToken(request);

        if (token == null) {
            return null;
        }

        Optional<RefreshToken> findRefreshToken =
                refreshTokenRepository.findByRefreshToken(request.getHeader(REFRESH_TOKEN_PREFIX));

        if (findRefreshToken.isPresent() && findRefreshToken.get().getExpirationPeriod().isAfter(LocalDateTime.now())) {

            Authentication authentication = tokenProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String accessToken = tokenProvider.createToken(authentication);

            // Refresh Token 유효기간 연장
            findRefreshToken.get().extendExpirationPeriod(LocalDateTime.now().plusSeconds(REFRESH_TOKEN_VALIDITY_IN_SECONDS));

            return new AccessTokenRes(accessToken);
        }

        return null;
    }

    /**
     * 만료된 refresh token 을 삭제합니다.
     */
    @Scheduled(fixedDelay = 1800000)
    public void clearExpiredRefreshToken() {

        int beforeSize = refreshTokenRepository.findAll().size();

        refreshTokenRepository.deleteAllByExpirationPeriodBefore(LocalDateTime.now());

        log.info("=======refresh token 정리 스케줄러 실행 시작=======");
        log.info("삭제한 refresh Token 개수 : {}", beforeSize - refreshTokenRepository.findAll().size());
        log.info("=======refresh token 정리 스케줄러 실행 끝=======");
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User findUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("해당 이메일에 해당하는 사용자를 찾을 수 없습니다."));

        return new org.springframework.security.core.userdetails.User(findUser.getEmail(),
                findUser.getPassword(), AuthorityUtils.createAuthorityList("USER"));

    }

    public boolean existEmail(String email) {

        return userRepository.existsByEmail(email);
    }

    public boolean existAccountName(String name) {

        return userRepository.existsByAccountName(name);
    }

    private String getAccessToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        String prefix = "Bearer ";

        if (header == null) {
            return null;
        }

        return header.substring(prefix.length());

    }
}