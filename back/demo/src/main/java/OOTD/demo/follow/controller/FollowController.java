package OOTD.demo.follow.controller;

import OOTD.demo.common.HttpResponseUtil;
import OOTD.demo.follow.service.FollowService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 팔로우 관계 관련 컨트롤러입니다.
 *
 * @author CHO Min Ho
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/follow")
@Slf4j
public class FollowController {

    private final FollowService followService;
    private final HttpResponseUtil httpResponseUtil;

    @GetMapping("/{id}")
    public ResponseEntity<?> createFollower(@PathVariable Long id) {

        return httpResponseUtil.createOkHttpResponse(followService.createFollower(id), "팔로우에 성공했습니다.");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFollower(@PathVariable Long id) {

        followService.deleteFollower(id);

        return httpResponseUtil.createOkHttpResponse(null, "팔로우 취소에 성공했습니다.");

    }
}
