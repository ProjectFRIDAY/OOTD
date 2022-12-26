package OOTD.demo.search.repository;

import OOTD.demo.diary.Diary;
import OOTD.demo.diary.dto.PostDiaryResDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * JPA Search repository 입니다.
 * @version 1.0.0
 * @author CHO Tae Wan
 */
public interface SearchRepository extends JpaRepository<Diary, Long> {
    Page<PostDiaryResDTO> findByTagName(String tagName, Pageable pageable);
    Page<PostDiaryResDTO> findByDiaryTitle(String diaryTitle, Pageable pageable);
    Page<PostDiaryResDTO> findByUserName(String userName, Pageable pageable);
}