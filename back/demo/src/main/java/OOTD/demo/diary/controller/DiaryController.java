package OOTD.demo.diary.controller;

import OOTD.demo.diary.dto.PostDiaryReqDTO;
import OOTD.demo.diary.dto.UpdateDiaryReqDTO;
import OOTD.demo.diary.service.DiaryService;
import OOTD.demo.domain.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

/**
 * Diary 엔티티 관련 컨트롤러입니다.
 * @version 1.0.0
 * @author CHO Min Ho
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class DiaryController {

    private final DiaryService diaryService;

    /**
     * 게시글 생성 컨트롤러 메서드입니다.
     * @param dto 게시글 생성 DTO
     * @return 생성된 게시글의 ID
     */
    @PostMapping("/api/diary/create")
    public ResponseEntity<?> createDiary(@RequestBody PostDiaryReqDTO dto) {

        // TODO : 현재 로그인된 사용자를 가져오는 로직 필요

        return createResponseEntity(diaryService.createPost(dto, null), "게시글 생성에 성공했습니다.");
    }

    /**
     * 단일 게시글을 조회하는 컨트롤러 메서드입니다.
     * @param id 게시글 ID
     * @return 해당 게시글의 정보를 담고 있는 DTO
     */
    @GetMapping("/api/diary/{id}")
    public ResponseEntity<?> findDiary(@PathVariable(name = "id") Long id) {

        // TODO : 공개 여부에 따라 퍼미션 거부 로직 필요

        return createResponseEntity(diaryService.findDiaryById(id), "게시글 조회에 성공했습니다.");
    }

    /**
     * 게시글 업데이트 관련 컨트롤러 메서드입니다.
     * @param dto 업데이트할 게시글 정보를 담고 있는 DTO
     * @return 업데이트한 게시글 엔티티의 ID
     */
    @PostMapping("/api/diary/update")
    public ResponseEntity<?> updateDiary(@RequestBody UpdateDiaryReqDTO dto) {

        // TODO : 현재 로그인된 사용자를 가져오는 로직 필요

        return createResponseEntity(diaryService.updatePost(dto, null), "게시글 수정에 성공했습니다.");
    }

    /**
     * 게시글 삭제 관련 컨트롤러 메서드입니다.
     * @param id 삭제할 게시글 id
     * @return 성공 여부
     */
    @GetMapping("/api/diary/delete/{id}")
    public ResponseEntity<?> deleteDiary(@PathVariable(name = "id") Long id) {

        // TODO : 현재 로그인된 사용자를 가져오는 로직 필요

        diaryService.deleteDiary(id, null);

        // TODO : 반환할 값이 없는 경우 반환할 양식 규정 필요
        return createResponseEntity(null, "게시글 삭제에 성공했습니다.");
    }

    /**
     * 컨트롤러에서 반환할 객체를 생성하는 메서드입니다.
     * @param object 실제 return되는 데이터
     * @param responseMessage 응답 메시지
     * @return 반환할 responseEntity 객체
     */
    private ResponseEntity<?> createResponseEntity(Object object, String responseMessage) {
        Message message = new Message();
        HttpHeaders headers = new HttpHeaders();
        message.setStatus(Message.StatusEnum.OK);
        message.setMessage(responseMessage);
        message.setData(object);
        return new ResponseEntity<>(message, headers, OK);
    }

}
