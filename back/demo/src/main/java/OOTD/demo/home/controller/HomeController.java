package OOTD.demo.home.controller;

import OOTD.demo.common.HttpResponseUtil;
import OOTD.demo.home.service.HomeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/home")
@Slf4j
public class HomeController {

    private final HomeService homeService;
    private final HttpResponseUtil httpResponseUtil;

    /**
     * 현재 사용자의 홈 캘린더를 반환하는 메서드입니다.
     *
     * @return 홈 캘린더 response 객체
     */
    @GetMapping
    public ResponseEntity<?> getHomeCalender(@RequestParam int year, @RequestParam int month) {

        return httpResponseUtil.createOkHttpResponse(homeService.getHomeCalender(year, month),
                "홈 캘린더 반환에 성공했습니다.");
    }

}
