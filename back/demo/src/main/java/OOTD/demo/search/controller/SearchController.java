package OOTD.demo.search.controller;

import OOTD.demo.common.HttpResponseUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import OOTD.demo.search.dto.*;

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
    private final HttpResponseUtil httpResponseUtil;
    @PostMapping("/api/search/TagName/{TagName}")
    public ResponseEntity<?> searchTagName(@PathVariable("TageName") String TagName, @RequestBody SearchDTO dto) {

        // TODO : 데이터 베이스에서 TagName 검색 결과를 불러오는 로직 필요
        // TagName 검색 결과를 불러온다. -> DiaryTitle 리스트 반환

        return httpResponseUtil.createOKHttpResponse(dto, "TagName 검색 결과");
    }
    @PostMapping("/api/search/DiaryTitle/{DiaryTitle}")
    public ResponseEntity<?> searchDiaryTitle(@PathVariable("DiaryTitle") String DiaryTitle, @RequestBody SearchDTO dto) {

        // TODO : 데이터 베이스에서 DiaryTiitle 검색 결과를 불러오는 로직 필요
        // DiaryTitle 검색 결과를 불러온다. -> DiaryTitle 리스트 반환

        return httpResponseUtil.createOKHttpResponse(dto, "DiaryTitle 검색 결과");
    }
    @PostMapping("/api/search/UserName/{UserName}")
    public ResponseEntity<?> searchUserName(@PathVariable("UserName") String UserName, @RequestBody SearchDTO dto) {

        // TODO : 데이터 베이스에서 UserName 검색 결과를 불러오는 로직 필요
        // UserName 검색 결과를 불러온다. -> 유저가 가진 DiaryTitle 리스트 반환

        return httpResponseUtil.createOKHttpResponse(dto, "UserName 검색 결과");
    }
}
