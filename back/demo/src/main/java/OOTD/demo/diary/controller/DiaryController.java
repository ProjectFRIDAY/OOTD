package OOTD.demo.diary.controller;

import OOTD.demo.diary.dto.PostDiaryReqDTO;
import OOTD.demo.diary.dto.PostDiaryResDTO;
import OOTD.demo.diary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
