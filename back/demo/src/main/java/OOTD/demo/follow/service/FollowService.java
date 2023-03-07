package OOTD.demo.follow.service;

import OOTD.demo.auth.service.AuthService;
import OOTD.demo.follow.Follow;
import OOTD.demo.follow.repository.FollowRepository;
import OOTD.demo.user.User;
import OOTD.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class FollowService {

    private final FollowRepository followRepository;
    private final AuthService authService;
    private final UserRepository userRepository;

    /**
     * 팔로우 관계를 생성하는 메서드입니다.
     * @param id 팔로우할 대상의 user id
     * @return 생성된 팔로우 엔티티의 id
     */
    public Long createFollower(Long id) {

        User currentLoginUser = authService.getCurrentLoginUser();

        return followRepository.save(Follow.createFollow(currentLoginUser,
                userRepository.findById(id).orElseThrow(IllegalArgumentException::new))).getId();
    }

    /**
     * 팔로우 관계를 삭제하는 메서드입니다.
     * @param id 대상 팔로워의 user id
     */
    public void deleteFollower(Long id) {

        followRepository.deleteByFollower(userRepository.findById(id).orElseThrow(IllegalArgumentException::new));

    }

}
