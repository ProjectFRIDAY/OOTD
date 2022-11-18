package OOTD.demo.service.user;


import OOTD.demo.api.dto.user.ReadUserDto;
import OOTD.demo.api.dto.user.UpdateUserDto;
import OOTD.demo.domain.user.User;
import OOTD.demo.repository.user.UserRepository;
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
            member.setName(user.getUserName());
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
        dto.setUserName(member.getName());
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
