package OOTD.demo.hashtag.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * 해시태그 생성시 사용되는 Request 클래스입니다.
 *
 * @author CHO Min Ho
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostHashTagReq {

    @NotEmpty(message = "이름을 입력해주세요!")
    String name;

}
