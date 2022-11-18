package OOTD.demo.common;


import lombok.Data;

@Data
public class Message {
    private StatusEnum status;
    private String message;
    private Object data;

    public enum StatusEnum{
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
    }
}
