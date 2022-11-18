package OOTD.demo.diarylike;

import OOTD.demo.diary.Diary;
import OOTD.demo.domain.user.User;
import lombok.Getter;
import javax.persistence.*;

/**
 * 게시글 좋아요 엔티티입니다.
 * @version 1.0.0
 * @author CHO Min Ho
 */
@Entity
@Getter
@Table(name = "DIARY_LIKE")
public class DiaryLike {

    @Id
    @GeneratedValue
    @Column(name = "diary_like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diary_id")
    private Diary diary;

    protected DiaryLike() { }

    private DiaryLike(User user, Diary diary) {
        this.user = user;
        this.diary = diary;
    }

    /**
     * 게시글 좋아요 엔티티 생성 메서드입니다.
     * 게시글 좋아요 엔티티는 해당 메서드로만 생성됩니다.
     * @param user 좋아요 작성자
     * @param diary 좋아요 대상 게시글
     * @return 생성된 DiaryLike 엔티티
     */
    public static DiaryLike createDiaryLike(User user, Diary diary) {
        return new DiaryLike(user, diary);
    }
}
