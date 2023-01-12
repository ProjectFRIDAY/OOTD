package OOTD.demo.diary;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 게시글 공개 범위 관련 enum 클래스입니다.
 * @version 1.0.0
 * @author CHO Min Ho
 */
public enum PublicScope {
    ALL("ALL"),
    FOLLOW("FOLLOW"),
    ME("ME");

    private String value;

    PublicScope(String value) {
        this.value = value;
    }

    @JsonCreator
    public static PublicScope from(String value) {
        for (PublicScope scope : PublicScope.values()) {
            if (scope.getValue().equals(value)) {
                return scope;
            }
        }
        return null;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
