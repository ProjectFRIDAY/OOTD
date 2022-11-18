package OOTD.demo.diarylike.repository;

import OOTD.demo.diary.Diary;
import OOTD.demo.diarylike.DiaryLike;
import OOTD.demo.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * DiaryLike 엔티티 관련 repository 클래스입니다.
 * @version 1.0.0
 * @author CHO Min Ho
 */
public interface DiaryLikeRepository extends JpaRepository<DiaryLike, Long> {
    List<DiaryLike> findAllByDiary(Diary diary);
    List<DiaryLike> findAllByUser(User user);
}
