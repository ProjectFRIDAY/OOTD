package OOTD.demo.diarylike.service;

import OOTD.demo.diary.Diary;
import OOTD.demo.diary.repository.DiaryRepository;
import OOTD.demo.diarylike.DiaryLike;
import OOTD.demo.diarylike.dto.PostDiaryLikeReqDTO;
import OOTD.demo.diarylike.dto.PostDiaryLikeResDTO;
import OOTD.demo.diarylike.repository.DiaryLikeRepository;
import OOTD.demo.domain.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;

/**
 * 게시글 좋아요 관련 서비스 클래스입니다.
 * @version 1.0.0
 * @author CHO Min Ho
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class DiaryLikeService {

    private final DiaryLikeRepository diaryLikeRepository;
    private final DiaryRepository diaryRepository;

    /**
     * 게시글 좋아요 엔티티를 생성하는 메서드입니다.
     * @param dto diary의 ID를 담고 있는 DTO
     * @param user 좋아요를 누른 사용자
     * @return 생성된 DiaryLIke 엔티티의 ID를 담고 있는 DTO
     */
    public PostDiaryLikeResDTO createDiaryLike(PostDiaryLikeReqDTO dto, User user) {
        Optional<Diary> diary = diaryRepository.findById(dto.getDiaryId());

        if (diary.isEmpty()) {
            // TODO : diary가 없을 시 예외 처리 로직 필요
        }

        DiaryLike diaryLike = diaryLikeRepository.save(DiaryLike.createDiaryLike(user, diary.get()));
        return new PostDiaryLikeResDTO(diaryLike.getId());
    }
}
