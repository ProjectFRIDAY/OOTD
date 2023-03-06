package OOTD.demo.dress.repository;

import OOTD.demo.dress.Dress;
import OOTD.demo.dress.DressHashTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * DressHashTag JPA Repository 입니다.
 *
 * @author CHO Min Ho
 */
public interface DressHashTagRepository extends JpaRepository<DressHashTag, Long> {
    List<DressHashTag> findByDress(Dress dress);
}
