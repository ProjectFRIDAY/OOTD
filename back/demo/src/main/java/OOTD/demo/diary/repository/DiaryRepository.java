package OOTD.demo.diary.repository;

import OOTD.demo.domain.user.User;
import OOTD.demo.diary.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * JPA Diary repository 입니다.
 * @version 1.0.0
 * @author CHO Min Ho
 */
public interface DiaryRepository extends JpaRepository<Diary, Long> {
    List<Diary> findByUser(User user);
}
