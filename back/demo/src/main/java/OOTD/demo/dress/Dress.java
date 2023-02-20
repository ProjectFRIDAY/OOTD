package OOTD.demo.dress;

import OOTD.demo.user.User;
import lombok.Getter;
import javax.persistence.*;

/**
 * 옷 엔티티 클래스입니다.
 *
 * @author CHO Min Ho
 * @version 1.0.0
 */
@Entity
@Getter
@Table(name = "DRESS")
public class Dress {
    @Id
    @GeneratedValue
    @Column(name = "dress_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "dress_name")
    private String dressName;

    @Enumerated(EnumType.STRING)
    @Column(name = "dress_type")
    private DressType dressType;

    @Column(name = "dress_img_url", columnDefinition = "TEXT")
    private String dressImageUrl;

    @Column(name = "dress_hashtag", columnDefinition = "TEXT")
    private String hashTag;

    private Dress(User user, String dressName, DressType dressType, String hashTag, String dressImageUrl) {
        this.user = user;
        this.dressName = dressName;
        this.dressType = dressType;
        this.hashTag = hashTag;
        this.dressImageUrl = dressImageUrl;
    }
    protected Dress() { }

    /**
     * Dress 엔티티 생성 메서드입니다.
     * @param user 옷 생성 사용자
     * @param dressImageUrl 옷 대표 이미지 URL
     * @param hashTag 해시태그
     * @return 생성된 Dress 엔티티
     */
    public static Dress createDress(User user, String dressName, DressType dressType, String hashTag, String dressImageUrl) {
        return new Dress(user, dressName, dressType, hashTag, dressImageUrl);
    }

}
