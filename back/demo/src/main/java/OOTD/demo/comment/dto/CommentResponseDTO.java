package OOTD.demo.comment.dto;

import OOTD.demo.comment.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CommentResponseDTO {
    private Boolean isSuccessful;
    public static CommentResponseDTO of(Comment comment) {
        return CommentResponseDTO.builder()
                .isSuccessful(true)
                .build();
    }
}
