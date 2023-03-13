package OOTD.demo.comment;

import lombok.Builder;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Builder
@Setter
public class Comment {
    @Id
    @GeneratedValue
    @Column()
    private Long id;
    @Column(name = "post_id", nullable = false)
    private Long postId;
    @Column(name = "Content", nullable = false)
    private String content;
    @Column(name = "user_id", nullable = false)
    private Long userId;
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;
    @Column(name = "isDeleted", nullable = false)
    private boolean isDeleted;

    public Comment() {
    }
    @Builder
    public Comment(Long id, Long postId, String content, Long userId, LocalDateTime createdDate, boolean isDeleted){
        this.id = id;
        this.postId = postId;
        this.content = content;
        this.userId = userId;
        this.createdDate = createdDate;
        this.isDeleted = isDeleted;
    }
}
