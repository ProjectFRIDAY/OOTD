package OOTD.demo.search.repository;

import OOTD.demo.diary.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * JPA Search repository 입니다.
 * @version 1.0.0
 * @author CHO Tae Wan
 */
public interface SearchRepository extends JpaRepository<Diary, Long> {
    List<Diary> findByTagName(String tagName);
    List<Diary> findByDiaryTitle(String diaryTitle);
    List<Diary> findByUserName(String userName);
}