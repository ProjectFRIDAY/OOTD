package OOTD.demo.comment.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PostCommentReq {

    @NotNull(message = "diary id 를 입력해주세요!")
    private Long diaryId;

    private Long parentCommentId;

    @NotBlank(message = "댓글 내용을 입력해주세요!")
    private String content;

}
