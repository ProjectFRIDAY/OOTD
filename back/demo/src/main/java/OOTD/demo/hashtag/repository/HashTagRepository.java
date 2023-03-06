package OOTD.demo.hashtag.repository;

import OOTD.demo.hashtag.HashTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * 해시태그 JPA Repository 입니다.
 *
 * @author CHO Min Ho
 */
public interface HashTagRepository extends JpaRepository<HashTag, Long> {

    Optional<HashTag> findByName(String name);

}
