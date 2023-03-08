package OOTD.demo.config.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.GenericFilterBean;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RequiredArgsConstructor
@Slf4j
public class CustomAuthenticationFilter extends GenericFilterBean {

    private final UserDetailsService userDetailsService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {


        // 1. 쿠키에서 세션 추출
        Cookie[] cookies = ((HttpServletRequest) request).getCookies();

        // 2. 쿠키에 유효한 사용자 정보가 있는지 검증
        HttpSession session = ((HttpServletRequest) request).getSession();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("auth")) {
                    String userAuthenticationInfo = cookie.getValue();

                    if (session.getAttribute(userAuthenticationInfo) != null) {
                        String userName = (String) session.getAttribute(userAuthenticationInfo);
                        // 사용자 정보 로드
                        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
                        SecurityContextHolder.getContext()
                                .setAuthentication(new UsernamePasswordAuthenticationToken(userDetails,
                                        "", userDetails.getAuthorities()));
                    }
                }
            }
        }
        
        chain.doFilter(request, response);
    }
}