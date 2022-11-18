package OOTD.demo.common;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import static org.springframework.http.HttpStatus.OK;

/**
 * 컨트롤러에서 반환하는 공통 양식을 생성하는 Util 클래스입니다.
 * @version 1.0.0
 * @author CHO Min Ho
 */
@Component
public class HttpResponseUtil {

    /**
     * 정상적인 요청에 대한 성공시 컨트롤러에서 반환할 객체를 생성하는 메서드입니다.
     * @param object 실제 return되는 데이터
     * @param responseMessage 응답 메시지
     * @return 반환할 responseEntity 객체
     */
    public ResponseEntity<?> createOKHttpResponse(Object object, String responseMessage) {
        Message message = new Message();
        HttpHeaders headers = new HttpHeaders();
        message.setStatus(Message.StatusEnum.OK);
        message.setMessage(responseMessage);
        message.setData(object);
        return new ResponseEntity<>(message, headers, OK);
    }
}
