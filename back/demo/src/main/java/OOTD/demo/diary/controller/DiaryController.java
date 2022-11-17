package OOTD.demo.diary.controller;

import OOTD.demo.diary.dto.DiaryDTO;
import OOTD.demo.diary.dto.PostDiaryReqDTO;
import OOTD.demo.diary.dto.PostDiaryResDTO;
import OOTD.demo.diary.dto.UpdateDiaryReqDTO;
import OOTD.demo.diary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
    public PostDiaryResDTO createDiary(@RequestBody PostDiaryReqDTO dto) {

        // TODO : 현재 로그인된 사용자를 가져오는 로직 필요

        return diaryService.createPost(dto, null);
    }

    /**
     * 단일 게시글을 조회하는 컨트롤러 메서드입니다.
     * @param id 게시글 ID
     * @return 해당 게시글의 정보를 담고 있는 DTO
     */
    @GetMapping("/api/diary/{id}")
    public DiaryDTO findDiary(@PathVariable(name = "id") Long id) {

        // TODO : 공개 여부에 따라 퍼미션 거부 로직 필요

        return diaryService.findDiaryById(id);
    }

    /**
     * 게시글 업데이트 관련 컨트롤러 메서드입니다.
     * @param dto 업데이트할 게시글 정보를 담고 있는 DTO
     * @return 업데이트한 게시글 엔티티의 ID
     */
    @PostMapping("/api/diary/update")
    public PostDiaryResDTO updateDiary(@RequestBody UpdateDiaryReqDTO dto) {

        // TODO : 현재 로그인된 사용자를 가져오는 로직 필요

        return diaryService.updatePost(dto, null);
    }

}
