package OOTD.demo.auth.service;


import OOTD.demo.auth.TokenProvider;
import OOTD.demo.auth.dto.CreateUserReq;
import OOTD.demo.auth.dto.LoginReq;
import OOTD.demo.auth.dto.LoginRes;
import OOTD.demo.auth.filter.JwtFilter;
import OOTD.demo.user.User;
import OOTD.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

    private final String TOKEN_PREFIX = "Bearer ";
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

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

        String token = tokenProvider.createToken(authentication);

        response.addHeader(JwtFilter.AUTHORIZATION_HEADER, TOKEN_PREFIX + token);

        return new LoginRes(member.getId(), token);
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
     * 로그아웃 (세션 삭제)를 담당하는 메서드입니다.
     * @param session HTTP Session
     */
    public void logout(HttpSession session) {
        session.invalidate();
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

}