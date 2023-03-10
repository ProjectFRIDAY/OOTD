package OOTD.demo.comment.dto;

import OOTD.demo.comment.Comment;
import OOTD.demo.user.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentRes {

    private Long commentId;
    private Long userId;
    private String userAccountName;
    private String userProfileImageUrl;
    private String content;
    private LocalDateTime lastModifiedAt;

    public static CommentRes of(Comment comment) {
        return new CommentRes(
                comment.getId(),
                comment.getUser().getId(),
                comment.getUser().getAccountName(),
                comment.getUser().getProfileImg(),
                comment.getContent(),
                comment.getLastModifiedTime()
                );
    }

}
