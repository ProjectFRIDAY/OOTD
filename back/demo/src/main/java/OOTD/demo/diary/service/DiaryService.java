package OOTD.demo.diary.service;

import OOTD.demo.diary.Diary;
import OOTD.demo.diary.dto.PostDiaryReqDTO;
import OOTD.demo.diary.dto.PostDiaryResDTO;
import OOTD.demo.diary.repository.DiaryRepository;
import OOTD.demo.domain.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Diary 엔티티 관련 서비스 클래스입니다.
 * @version 1.0.0
 * @author CHO Min Ho
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class DiaryService {

    private final DiaryRepository diaryRepository;

    /**
     * 게시글을 생성하는 메서드입니다.
     * TODO : 파일 업로드 관련 로직 추가
     * @param dto 게시글 생성 관련 엔티티
     * @param user 게시글 생성 User
     * @return 생성된 게시글 엔티티의 ID를 포함한 DTO
     */
    public PostDiaryResDTO createPost(PostDiaryReqDTO dto, User user) {
        Diary diary = diaryRepository.save(Diary.createPost(dto, user));
        return new PostDiaryResDTO(diary.getId());
    }

    /**
     * 게시글 엔티티 수정 메서드입니다.
     * @param id 수정할 게시글 ID
     * @param dto 수정할 게시글의 사항 관련 DTO
     * @return 수정된 게시글의 ID를 포함한 DTO
     */
    public PostDiaryResDTO updatePost(Long id, PostDiaryReqDTO dto) {
        Optional<Diary> diary = diaryRepository.findById(id);
        
        if (diary.isEmpty()) {
            // TODO : 예외 처리 시 반환할 공통 메서드 필요
        }

        diary.get().updateDiary(dto);
        return new PostDiaryResDTO(diary.get().getId());

    }

}
