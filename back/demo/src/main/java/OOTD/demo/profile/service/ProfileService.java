package OOTD.demo.profile.service;

import OOTD.demo.auth.service.AuthService;
import OOTD.demo.follow.repository.FollowRepository;
import OOTD.demo.profile.dto.ProfileDTO;
import OOTD.demo.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ProfileService {
    private final FollowRepository followRepository;
    private final AuthService authService;
    /**
     * my Profile을 조회하는 메서드입니다.
     * @param
     * @return 나의 프로필 정보를 담고 있는 DTO
     */
    public ProfileDTO viewMyProfile() {
        User currentLoginUser = authService.getCurrentLoginUser();
        return ProfileDTO.builder()
                .followerCount(followRepository.countByFollower_Id(currentLoginUser.getId()))
                .followingCount(followRepository.countByFollowee_Id(currentLoginUser.getId()))
                .userId(currentLoginUser.getId())
                .userName(currentLoginUser.getAccountName())
                .userProfileImg(currentLoginUser.getProfileImg())
                .build();
    }
    /**
     * 다른사람의 Profile을 조회하는 메서드입니다.
     * @param
     * @return 해당 프로필의 정보를 담고 있는 DTO
     */
    public ProfileDTO viewProfile(Long userId) {
        return ProfileDTO.builder()
                .followerCount(followRepository.countByFollower_Id(userId))
                .followingCount(followRepository.countByFollowee_Id(userId))
                .userId(userId)
                .userName("test")
                .userProfileImg("test")
                .build();
    }
}
