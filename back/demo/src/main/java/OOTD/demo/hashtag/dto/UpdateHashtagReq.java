package OOTD.demo.hashtag.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 해시태그 엔티티 수정 관련 엔티티 메서드입니다.
 *
 * @author CHO Min Ho
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateHashtagReq {
    @NotNull(message = "해시태그 아이디를 입력해주세요!")
    private Long id;

    @NotEmpty(message = "해시태그 이름을 입력해주세요!")
    private String name;
}
