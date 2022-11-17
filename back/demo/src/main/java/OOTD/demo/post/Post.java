package OOTD.demo.post;

import OOTD.demo.domain.user.User;
import lombok.Getter;
import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 게시글 엔티티입니다.
 * TODO : Weather 엔티티 추가 시 weather 멤버 추가
 * @version 1.0.0
 * @author CHO Min Ho
 */
@Entity
@Getter
@Table(name = "POST")
public class Post {

    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    @Column(name = "post_title", nullable = false)
    private String title;

    @Column(name = "post_content", columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(name = "post_created_date", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "post_update_date", nullable = false)
    private LocalDateTime updateDate;

    @Column(name = "post_is_updated")
    private boolean isUpdated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    protected Post() { }

    private Post(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.createDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
        this.isUpdated = false;
        this.user = user;
    }

    /**
     * 게시글 엔티티 생성 메서드입니다.
     * 게시글 생성은 해당 메서드로만 진행됩니다.
     * @param title 게시글 제목
     * @param content 게시글 내용
     * @param user 게시글 작성자
     * @return 생성된 Post 엔티티
     */
    public static Post createPost(String title, String content, User user) {
        return new Post(title, content, user);
    }
}
