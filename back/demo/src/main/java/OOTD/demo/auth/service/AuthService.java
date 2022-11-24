package OOTD.demo.auth.service;


import OOTD.demo.auth.dto.CreateUserDto;
import OOTD.demo.auth.dto.LoginDto;
import OOTD.demo.user.User;
import OOTD.demo.user.repository.UserRepository;
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

    public boolean existsEmail(String email) {
        return userRepository.existsByEmail(email);
    }


    public boolean existsName(String name) {
        return userRepository.existsByName(name);
    }

    public boolean checkPassword(Long id, String pw){
        User user = userRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found uwer"));
        if(!passwordEncoder.matches(pw, user.getPassword())){
            throw new IllegalArgumentException("wrong password");
        }
        return true;
    }
}