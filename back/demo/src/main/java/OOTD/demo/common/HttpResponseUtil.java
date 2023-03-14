package OOTD.demo.common;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON;

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
     * @return 반환할 ResponseEntity 객체
     */
    public ResponseEntity<?> createOkHttpResponse(Object object, String responseMessage) {
        Message message = new Message();
        message.setStatus(Message.StatusEnum.OK);
        message.setMessage(responseMessage);
        message.setData(object);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(APPLICATION_JSON);
        return new ResponseEntity<>(message, httpHeaders, OK);
    }

    /**
     * 에러 케이스에서 컨트롤러에서 반환할 객체를 생성하는 메서드입니다.
     * @param object return되는 데이터
     * @param responseMessage 응답 메시지
     * @param status HTTP Status
     * @return 반환할 ResponseEntity 객체
     */
    public ResponseEntity<?> createErrorResponse(Object object, String responseMessage, HttpStatus status) {
        Message message = new Message();
        message.setStatus(Message.StatusEnum.from(status));
        message.setMessage(responseMessage);
        message.setData(object);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(APPLICATION_JSON);
        return new ResponseEntity<>(message, httpHeaders, status);
    }
}
