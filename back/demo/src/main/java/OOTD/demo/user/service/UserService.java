package OOTD.demo.user.service;


import OOTD.demo.user.dto.ReadUserDto;
import OOTD.demo.user.dto.UpdateUserDto;
import OOTD.demo.user.User;
import OOTD.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User userUpdate(Long id, UpdateUserDto user){
        User member = userRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not find user"));
        if(user.getUserName()!=null){
            member.setAccountName(user.getUserName());
        }
        if(user.getUserProfileImg()!=null){
            member.setProfileImg(user.getUserProfileImg());

        }
        return member;
    }
    public ReadUserDto readUser(Long id){
        User member = userRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("NOT find user"));
        ReadUserDto dto = new ReadUserDto();
        dto.setUserName(member.getAccountName());
        dto.setUserProfileImg(member.getProfileImg());
        dto.setUserId(member.getId());

        return dto;
    }

    @Transactional
    public void deleteUser(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found user"));
        userRepository.delete(user);
    }

    public User findByEmailAndBirth(String email, LocalDate birth){
        User user = userRepository.findByEmailAndBirth(email, birth)
                .orElseThrow(()->new IllegalArgumentException("not found user"));
        return user;
    }
    public User findUser(Long id){
        User user = userRepository.findById(id).orElseThrow(IllegalAccessError::new);
        return user;
    }
    @Transactional
    public void setNewPassword(Long userId, String newPassword){
        User user = userRepository.findById(userId)
                .orElseThrow(IllegalAccessError::new);
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);
    }
}
