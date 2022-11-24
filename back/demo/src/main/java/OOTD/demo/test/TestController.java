package OOTD.demo.test;

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
    @GetMapping("/test")
    public String test()  {
        return "success";
    }
}
