package OOTD.demo.diarylike.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

/**
 * 게시글 좋아요 request를 받을 때 사용되는 DTO입니다.
 * @version 1.0.0
 * @author CHO Min Ho
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDiaryLikeReqDTO {
    @NotNull(message = "diary ID를 입력해주세요!")
    private Long diaryId;
}
