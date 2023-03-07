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

}
