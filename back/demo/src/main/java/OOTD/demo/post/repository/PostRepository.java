package OOTD.demo.post.repository;

import OOTD.demo.domain.user.User;
import OOTD.demo.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * JPA Post repository입니다.
 * @version 1.0.0
 * @author CHO Min Ho
 */
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUser(User user);
}
