package OOTD.demo.hot.controller;


import OOTD.demo.common.HttpResponseUtil;
import OOTD.demo.hot.service.HotService;
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
 * Hot Diary 기능 컨트롤러입니다.
 * @version 1.0.0
 * @author CHO Tae Wan
 */
public class HotController {
    private final HttpResponseUtil httpResponseUtil;
    private final HotService hotService;
    @Operation(summary = "Hot Diary API", description = "Hot Diary API입니다.",
            tags = { "Hot Controller" })
    @GetMapping("/api/hot")
    public ResponseEntity<?> HotDiary() {
        return httpResponseUtil.createOkHttpResponse(hotService.getHotList(), "Hot Diary API입니다.");
    }
}
