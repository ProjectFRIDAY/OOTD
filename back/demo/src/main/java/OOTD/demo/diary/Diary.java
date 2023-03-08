package OOTD.demo.diary;

import OOTD.demo.diary.dto.PostDiaryReq;
import OOTD.demo.diary.dto.UpdateDiaryReq;
import OOTD.demo.user.User;
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
@Table(name = "DIARY")
public class Diary {

    @Id
    @GeneratedValue
    @Column(name = "diary_id")
    private Long id;

    @Column(name = "diary_title", nullable = false)
    private String title;

    @Column(name = "diary_content", columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(name = "diary_created_date", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "diary_update_date", nullable = false)
    private LocalDateTime updateDate;

    @Column(name = "diary_is_updated")
    private boolean isUpdated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "diary_public_scope", nullable = false)
    private PublicScope publicScope;

    protected Diary() { }

    private Diary(String title, String content, User user, PublicScope scope) {
        this.title = title;
        this.content = content;
        this.createDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
        this.isUpdated = false;
        this.user = user;
        this.publicScope = scope;
    }

    /**
     * 게시글 엔티티 생성 메서드입니다.
     * 게시글 생성은 해당 메서드로만 진행됩니다.
     * @param user 게시글 작성자
     * @return 생성된 Post 엔티티
     */
    public static Diary createPost(String title, String content, PublicScope scope, User user) {
        return new Diary(title, content, user, scope);
    }

    /**
     * 게시글 엔티티 수정 메서드입니다.
     */
    public void updateDiary(String title, String content, PublicScope scope) {
        this.title = title;
        this.content = content;
        this.updateDate = LocalDateTime.now();
        this.publicScope = scope;
        this.isUpdated = true;
    }
}
