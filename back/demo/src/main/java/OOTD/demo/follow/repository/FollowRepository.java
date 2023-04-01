package OOTD.demo.follow.repository;

import OOTD.demo.follow.Follow;
import OOTD.demo.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Follow JPA repository 입니다.
 *
 * @author CHO Min Ho
 */
public interface FollowRepository extends JpaRepository<Follow, Long> {
    void deleteByFollower(User user);
    int countByFollower_Id(Long id);
    int countByFollowee_Id(Long id);
    void deleteAllByFollowee(User user);
    void deleteAllByFollower(User user);
}
