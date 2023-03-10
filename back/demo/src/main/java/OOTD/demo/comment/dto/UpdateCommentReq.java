package OOTD.demo.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCommentReq {

    @NotBlank(message = "댓글 내용을 적어주세요!")
    private String content;

}
