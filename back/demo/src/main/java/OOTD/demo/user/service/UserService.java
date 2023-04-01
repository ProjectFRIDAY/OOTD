package OOTD.demo.user.service;


import OOTD.demo.auth.repository.RefreshTokenRepository;
import OOTD.demo.diary.Diary;
import OOTD.demo.diary.repository.DiaryRepository;
import OOTD.demo.diary.service.DiaryService;
import OOTD.demo.dress.Dress;
import OOTD.demo.dress.repository.DressRepository;
import OOTD.demo.dress.service.DressService;
import OOTD.demo.follow.repository.FollowRepository;
import OOTD.demo.hot.repository.HotRepository;
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
    private final DiaryRepository diaryRepository;
    private final DressRepository dressRepository;
    private final DiaryService diaryService;
    private final RefreshTokenRepository refreshTokenRepository;
    private final DressService dressService;
    private final FollowRepository followRepository;
    private final HotRepository hotRepository;


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
    public void deleteUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found user"));

        for (Diary diary : diaryRepository.findByUser(user)) {
            diaryService.deleteDiary(diary.getId());
        }

        for (Dress dress : dressRepository.findByUser(user)) {
            dressService.deleteSingleDress(dress.getId());
        }

        followRepository.deleteByFollower(user);
        followRepository.deleteAllByFollowee(user);
        hotRepository.deleteAllByUserId(user.getId());
        refreshTokenRepository.deleteAllByUser(user);
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
