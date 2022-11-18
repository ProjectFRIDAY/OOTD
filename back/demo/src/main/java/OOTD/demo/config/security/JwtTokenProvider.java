package OOTD.demo.config.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.List;
@RequiredArgsConstructor
@Component
public class JwtTokenProvider {
    private String secretKey = "plantrowth";

    //토큰 유효시간
    private long tokenVaildTime = 30 * 60 * 1000L;

    private final UserDetailsService userDetailsService;

    //secretKey를 base64로 인코딩
    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    //jwt token 생성
    public String createToken(String userPk, List<String> roles) {
        Claims claims = Jwts.claims().setSubject(userPk); //jwt payload에 저장되는 단위
        claims.put("roles", roles); //key/value로 정보저장
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims) // 저장된 정보
                .setIssuedAt(now) // 토큰 생성 시간
                .setExpiration(new Date(now.getTime() + tokenVaildTime)) // 토큰 유효시간
                .signWith(SignatureAlgorithm.HS256, secretKey) //암호화 방식
                .compact();
    }

    //jwt 에서 인증 조회
    public Authentication getAuthentication(String token) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUserPk(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    //토큰 해석
    public String getUserPk(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    //Request header에서 token 값 불러옴. "X-AUTH* : toekn값"
    public String resolveToken(HttpServletRequest request){
        return request.getHeader("X-AUTH-TOKEN");
    }

    //토큰 유효 확인
    public boolean validateToken(String jwtToken){
        try{
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e){
            return false;
        }
    }
}