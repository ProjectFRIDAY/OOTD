package OOTD.demo.diarylike.service;

import OOTD.demo.auth.service.AuthService;
import OOTD.demo.diary.repository.DiaryRepository;
import OOTD.demo.diarylike.DiaryLike;
import OOTD.demo.diarylike.dto.PostDiaryLikeRes;
import OOTD.demo.diarylike.repository.DiaryLikeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

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
    private final AuthService authService;

    /**
     * 게시글 좋아요 엔티티를 생성하는 메서드입니다.
     * @param id diary 의 ID
     * @return 생성된 DiaryLIke 엔티티의 ID를 담고 있는 DTO
     */
    public PostDiaryLikeRes createDiaryLike(Long id) {

        return new PostDiaryLikeRes(diaryLikeRepository.save(DiaryLike.createDiaryLike(authService.getCurrentLoginUser(),
                diaryRepository.findById(id).orElseThrow(IllegalArgumentException::new))).getId());
    }

    /**
     * 게시글 좋아요 엔티티를 삭제하는 메서드입니다.
     * @param id 삭제하려는 DiaryLIke 엔티티의 ID
     */
    public void deleteDiaryLike(Long id) {
        DiaryLike findDiaryLike = diaryLikeRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        if (findDiaryLike.getUser().getId() != authService.getCurrentLoginUser().getId()) {
            // TODO : 좋아요를 누른 사용자가 요청하는 경우가 아닌 경우 (퍼미션 거부) 예외 처리 로직 필요
        }

        diaryLikeRepository.delete(findDiaryLike);
    }

    /**
     * 게시글 좋아요 개수를 반환하는 메서드입니다.
     * @param id 게시글 id
     * @return 해당 게시글의 좋아요 개수
     */
    public int getDiaryLikeCount(Long id) {
        return diaryLikeRepository.findAllByDiary(diaryRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new)).size();
    }

}
