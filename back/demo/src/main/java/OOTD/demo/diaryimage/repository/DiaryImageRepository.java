package OOTD.demo.diaryimage.repository;

import OOTD.demo.diary.Diary;
import OOTD.demo.diaryimage.DiaryImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * JPA DiaryImage repository 입니다.
 *
 * @version 1.0.0
 * @author CHO Min Ho
 */
public interface DiaryImageRepository extends JpaRepository<DiaryImage, Long> {
    List<DiaryImage> findByDiary(Diary diary);
}
