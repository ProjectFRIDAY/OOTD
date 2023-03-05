package OOTD.demo.comment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDTO {
    private Long postId;
    private String content;
    private Long userId;
}
