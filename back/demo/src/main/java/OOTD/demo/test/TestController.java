package OOTD.demo.test;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 테스트 컨트롤러입니다.
 * @version 1.0.0
 * @author CHO Min Ho
 */
@RestController
public class TestController {

    /**
     * Elastic beanstalk Health Check 용 메서드입니다.
     * @return "success'
     */
    @Operation(summary = "(테스트용) AWS EB Health Check용 API", description = "AWS 상태검사용 테스트 API입니다. (테스트용)",
            tags = { "Test Controller" })
    @GetMapping("/test")
    public String test()  {
        return "success";
    }
}
