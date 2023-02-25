package OOTD.demo.search.controller;

import OOTD.demo.common.HttpResponseUtil;
import OOTD.demo.search.service.SearchService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
/**
 * Search 기능 컨트롤러입니다.
 * @version 1.0.1
 * @author CHO Tae Wan
 */
public class SearchController {
    private final HttpResponseUtil httpResponseUtil;
    private final SearchService searchService;
    @Operation(summary = "게시글 검색 API(title)", description = "제목검색 API입니다.",
            tags = { "Search Controller" })
    @GetMapping("/api/search/title/{title}/{page}")
    public ResponseEntity<?> SearchDiaryByTitle(@PathVariable(name = "title") String title, @PathVariable(name = "page") int page) {

        return httpResponseUtil.createOKHttpResponse(searchService.SearchDiaryByTitle(title, page), "게시글 검색에 성공했습니다.");
    }

    @Operation(summary = "게시글 검색 API(tag)", description = "태그검색 API입니다.(미완성)",
            tags = { "Search Controller" })
    @GetMapping("/api/search/tag/{tag}")
    public ResponseEntity<?> SearchDiaryByTag(@PathVariable(name = "tag") String tag) {

        return null; //httpResponseUtil.createOKHttpResponse(searchService.SearchDiaryByTag(tag), "게시글 검색에 성공했습니다.");
    }
}
