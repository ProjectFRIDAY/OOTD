package OOTD.demo.diary_image.repository;

import OOTD.demo.diary_image.DiaryImage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA DiaryImage repository 입니다.
 *
 * @version 1.0.0
 * @author CHO Min Ho
 */
public interface DiaryImageRepository extends JpaRepository<DiaryImage, Long> {

}
