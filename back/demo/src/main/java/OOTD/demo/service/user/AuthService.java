package OOTD.demo.service.user;


import OOTD.demo.api.dto.auth.CreateUserDto;
import OOTD.demo.api.dto.auth.LoginDto;
import OOTD.demo.domain.user.User;
import OOTD.demo.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class AuthService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Transactional
    public Long createUser(CreateUserDto user) {
        Long userId = userRepository.save(
                        User.builder()
                                .name(user.getUserName())
                                .email(user.getEmail())
                                .password(user.getPassword())
                                .birth(user.getUserBirth())
                                .FCMAccessToken(user.getFcm_access_token())
                                .roles(Collections.singletonList("ROLE_USER"))
                                .build())
                .getId();
        return userId;
    }

    public User login(LoginDto user) {
        User member = userRepository.findByEmail(user.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("wrong id"));
        if (!passwordEncoder.matches(user.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("id or password aren't match");
        }
        return member;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("can't find user"));
    }

    public boolean existEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean existName(String name) {
        return userRepository.existByName(name);
    }
}