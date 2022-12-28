package OOTD.demo.search.controller;

import OOTD.demo.common.HttpResponseUtil;
import OOTD.demo.diary.dto.DiaryDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import OOTD.demo.diary.service.DiaryService;

/**
 * TagName, DiaryTitle, UserName을 검색하는 컨트롤러 클래스입니다.
 * @version 1.0.0
 * @author CHO Tae Wan
 */

@RestController
@RequiredArgsConstructor
@Slf4j
public class SearchController {
    /**
     * TagName, DiaryTitle, UserName을 검색하는 API입니다.
     * @param TagName, DiaryTitle, UserName
     * @return 검색 결과
     */
    private final DiaryService diaryService;
    private final HttpResponseUtil httpResponseUtil;
    @PostMapping("/api/search/TagName/{TagName}")
    public ResponseEntity<?> searchTagName(@PathVariable(name = "TagName") Long id, @RequestBody DiaryDTO dto) {

        // TODO :
        return httpResponseUtil.createOKHttpResponse(dto, "TagName 검색 결과");
    }
    @PostMapping("/api/search/DiaryTitle/{DiaryTitle}")
    public ResponseEntity<?> searchDiaryTitle(@PathVariable(name = "DiaryTitle") String DiaryTitle, @RequestBody DiaryDTO dto) {

        // TODO :
        return httpResponseUtil.createOKHttpResponse(dto, "DiaryTitle 검색 결과");
    }
    @PostMapping("/api/search/UserName/{UserName}")
    public ResponseEntity<?> searchUserName(@PathVariable(name = "UserName") String UserName, @RequestBody DiaryDTO dto) {

        // TODO :
        return httpResponseUtil.createOKHttpResponse(dto, "UserName 검색 결과");
    }
}
