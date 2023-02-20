package OOTD.demo.hashtag.controller;

import OOTD.demo.common.HttpResponseUtil;
import OOTD.demo.hashtag.dto.PostHashTagReq;
import OOTD.demo.hashtag.dto.UpdateHashtagReq;
import OOTD.demo.hashtag.service.HashTagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

/**
 * 해시태그 관련 컨트롤러 메서드입니다 (For Admin)
 *
 * @author CHO Min Ho
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class HashTagController {

    private final HashTagService hashTagService;
    private final HttpResponseUtil httpResponseUtil;

    @PostMapping("/api/hashtag")
    public ResponseEntity<?> createHashTag(@Valid @RequestBody PostHashTagReq req) {
        return httpResponseUtil.createOkHttpResponse(hashTagService.createHashTag(req),
                "해시태그 생성에 성공했습니다.");
    }

    @PutMapping("/api/hashtag")
    public ResponseEntity<?> updateHashTag(@Valid @RequestBody UpdateHashtagReq req) {
        return httpResponseUtil.createOkHttpResponse(hashTagService.updateHashTag(req),
                "해시태그 갱신에 성공했습니다.");
    }

    @DeleteMapping("/api/hashtag/{id}")
    public ResponseEntity<?> deleteHashTag(@PathVariable Long id) {
        hashTagService.deleteHashTag(id);
        return httpResponseUtil.createOkHttpResponse(null, "해시태그 삭제에 성공했습니다.");
    }


}
