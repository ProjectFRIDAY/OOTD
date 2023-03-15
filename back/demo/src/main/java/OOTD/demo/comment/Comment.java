package OOTD.demo.comment;

import OOTD.demo.common.BaseTimeEntity;
import OOTD.demo.diary.Diary;
import OOTD.demo.user.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "COMMENT")
public class Comment extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diary_id", nullable = false)
    private Diary diary;

    @Column(name = "comment_content", columnDefinition = "TEXT", nullable = false)
    private String content;

    @OneToOne
    @JoinColumn(name = "parent_comment_id")
    private Comment parentComment;

    private Comment(User user, Diary diary, String content, Comment parentComment) {
        this.user = user;
        this.diary = diary;
        this.content = content;
        this.parentComment = parentComment;
    }

    /**
     * Comment 엔티티를 만드는 메서드입니다.
     * @param user 댓글 작성자 id
     * @param diary 게시글 id
     * @param content 댓글 내용
     * @param comment 대댓글일 경우, 부모 댓글
     * @return 생성된 Comment 엔티티
     */
    public static Comment createComment(User user, Diary diary, String content, Comment comment) {
        return new Comment(user, diary, content, comment);
    }

    /**
     * Comment 엔티티를 수정하는 메서드입니다.
     * @param content 수정할 내용
     */
    public void updateComment(String content) {
        this.content = content;
    }
}
