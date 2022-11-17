package OOTD.demo.diary;

import OOTD.demo.diary.dto.PostDiaryReqDTO;
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
    @JoinColumn(name = "diary_id", nullable = false)
    private User user;

    protected Diary() { }

    private Diary(String title, String content, User user) {
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
     * @param dto 게시글 생성 관련 DTO
     * @param user 게시글 작성자
     * @return 생성된 Post 엔티티
     */
    public static Diary createPost(PostDiaryReqDTO dto, User user) {
        return new Diary(dto.getTitle(), dto.getContent(), user);
    }
}
