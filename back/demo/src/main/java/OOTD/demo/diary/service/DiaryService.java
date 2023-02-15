package OOTD.demo.diary.service;

import OOTD.demo.diary.Diary;
import OOTD.demo.diary.dto.DiaryDto;
import OOTD.demo.diary.dto.PostDiaryReq;
import OOTD.demo.diary.dto.PostDiaryRes;
import OOTD.demo.diary.dto.UpdateDiaryReq;
import OOTD.demo.diary.repository.DiaryRepository;
import OOTD.demo.diary_image.repository.DiaryImageRepository;
import OOTD.demo.file.FileUploadUtil;
import OOTD.demo.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static OOTD.demo.diary_image.DiaryImage.createDiaryImage;

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
    private final FileUploadUtil fileUploadUtil;
    private final DiaryImageRepository diaryImageRepository;

    /**
     * 게시글을 생성하는 메서드입니다.
     * TODO : 날씨 관련 로직 추가
     * @param dto 게시글 생성 관련 엔티티
     * @param user 게시글 생성 User
     * @param files 게시글 이미지 리스트
     * @return 생성된 게시글 엔티티의 ID를 포함한 DTO
     */
    public PostDiaryRes createPost(PostDiaryReq dto, List<MultipartFile> files, User user) {
        Diary diary = diaryRepository.save(Diary.createPost(dto, user));

        for (int i = 1; i <= files.size(); i++) {
            String diaryImageUrl = fileUploadUtil.uploadFile("diary", files.get(i - 1));
            diaryImageRepository.save(createDiaryImage(i, diary, diaryImageUrl));
        }

        return new PostDiaryRes(diary.getId());
    }

    /**
     * 게시글 엔티티 수정 메서드입니다.
     * @param dto 수정할 게시글의 사항 관련 DTO
     * @param user 현재 로그인된 사용자
     * @return 수정된 게시글의 ID를 포함한 DTO
     */
    public PostDiaryRes updatePost(UpdateDiaryReq dto, User user) {
        Optional<Diary> diary = diaryRepository.findById(dto.getId());

        if (diary.isEmpty()) {
            // TODO : 예외 처리 시 반환할 공통 메서드 필요
        }

        if (user.getId() != diary.get().getId()) {
            // TODO : 권한이 없는 사용자가 게시글 수정 시도시 예외 발생 로직 필요
        }

        diary.get().updateDiary(dto);
        return new PostDiaryRes(diary.get().getId());

    }

    /**
     * 게시글 삭제 메서드입니다.
     * @param id 삭제할 게시글 ID
     * @param user 현재 로그인된 사용자
     */
    public void deleteDiary(Long id, User user) {
        Optional<Diary> diary = diaryRepository.findById(id);

        if (diary.isEmpty()) {
            // TODO : 예외 처리 시 반환할 공통 메서드 필요
        }

        if (diary.get().getId() != user.getId()) {
            // TODO : 게시글을 삭제하려는 사용자가 해당 게시글의 작성자가 아닐 경우 퍼미션 오류 관련 처리 필요
        }

        diaryRepository.delete(diary.get());
    }

    /**
     * 게시글 ID를 이용하여 특정 게시글을 조회하는 메서드입니다.
     * @param id 게시글 ID
     * @return 해당 게시글의 정보를 담고 있는 DTO
     */
    public DiaryDto findDiaryById(Long id) {
        Optional<Diary> diary = diaryRepository.findById(id);

        if (diary.isEmpty()) {
            // TODO : 예외 처리 시 반환할 공통 메서드 필요
        }

        return new DiaryDto(diary.get().getId(), diary.get().getTitle(), diary.get().getContent(),
                diary.get().getCreateDate(), diary.get().getUpdateDate(), diary.get().getUser().getId());
    }

}
