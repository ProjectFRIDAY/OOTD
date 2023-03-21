package OOTD.demo.profile.controller;

import OOTD.demo.common.HttpResponseUtil;
import OOTD.demo.profile.service.ProfileService;
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
 * profile조회 controller입니다.
 * @version 1.0.0
 * @author CHO Tae Wan
 */
public class ProfileController {
    private final HttpResponseUtil httpResponseUtil;
    private final ProfileService profileService;
    @Operation(summary = "View my profile API", description = "본인 프로필 조회 API입니다.", tags = { "profile controller" })
    @GetMapping("/api/profile")
    public ResponseEntity<?> ViewMyProfile() {
        return httpResponseUtil.createOkHttpResponse(profileService.viewMyProfile(), "Hot Diary API입니다.");
    }

    @Operation(summary = "View profile API", description = "프로필 조회 API입니다.", tags = { "profile controller" })
    @GetMapping("/api/profile/{userId}")
    public ResponseEntity<?> ViewProfile(@PathVariable Long userId) {
        return httpResponseUtil.createOkHttpResponse(profileService.viewProfile(userId), "Hot Diary API입니다.");
    }
}
