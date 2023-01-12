package OOTD.demo.diary.dto;

import OOTD.demo.diary.PublicScope;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 게시글 엔티티 생성 관련 DTO입니다.
 * @version 1.0.0
 * @author CHO Min Ho
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDiaryReqDTO {
    @NotBlank(message = "제목을 입력해주세요!")
    private String title;
    @NotBlank(message = "내용을 입력해주세요!")
    private String content;
    @NotNull(message = "공개범위를 입력해주세요!")
    private PublicScope scope;
}
