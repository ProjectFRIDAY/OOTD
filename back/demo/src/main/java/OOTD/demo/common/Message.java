package OOTD.demo.common;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Message {
    private StatusEnum status;
    private String message;
    private Object data;

    public enum StatusEnum {
        OK(200, "OK"),
        BAD_REQUEST(400, "BAD_REQUEST"),
        NOT_FOUND(404, "NOT_FOUND"),
        INTERNAL_SERVER_ERROR(500, "INTERNAL_SERVER_ERROR"),
        NOT_ACCEPTABLE(406, "NOT_ACCEPTABLE");

        int statusCode;
        String code;

        StatusEnum(int statusCode, String code) {
            this.statusCode = statusCode;
            this.code = code;
        }

        /**
         * HttpStatus 객체를 StatusEnum 객체르 바꾸는 메서드입니다.
         * @param status HttpStatus 객체
         * @return 해당하는 StatusEnum 객체
         */
        public static StatusEnum from(HttpStatus status) {
            for (StatusEnum statusEnum : StatusEnum.values()) {
                if (statusEnum.statusCode == status.value()) {
                    return statusEnum;
                }
            }
            return OK;
        }
    }
}
