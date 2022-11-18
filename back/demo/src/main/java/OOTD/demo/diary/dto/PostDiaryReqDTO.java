package OOTD.demo.diary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;

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
}
