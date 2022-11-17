package OOTD.demo.diary.controller;

import OOTD.demo.diary.dto.DiaryDTO;
import OOTD.demo.diary.dto.PostDiaryReqDTO;
import OOTD.demo.diary.dto.PostDiaryResDTO;
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

    @PostMapping("/api/diary/create")
    public PostDiaryResDTO createDiary(@RequestBody PostDiaryReqDTO dto) {

        // TODO : 현재 로그인된 사용자를 가져오는 로직 필요

        return diaryService.createPost(dto, null);
    }

    @GetMapping("/api/diary/{id}")
    public DiaryDTO findDiary(@PathVariable(name = "id") Long id) {

        // TODO : 공개 여부에 따라 퍼미션 거부 로직 필요

        return diaryService.findDiaryById(id);
    }

}
