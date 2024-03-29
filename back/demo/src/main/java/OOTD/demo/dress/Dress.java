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

    private Dress(User user, String dressName, DressType dressType, String dressImageUrl) {
        this.user = user;
        this.dressName = dressName;
        this.dressType = dressType;
        this.dressImageUrl = dressImageUrl;
    }
    protected Dress() { }

    /**
     * Dress 엔티티 생성 메서드입니다.
     * @param user 옷 생성 사용자
     * @param dressImageUrl 옷 대표 이미지 URL
     * @return 생성된 Dress 엔티티
     */
    public static Dress createDress(User user, String dressName, DressType dressType, String dressImageUrl) {
        return new Dress(user, dressName, dressType, dressImageUrl);
    }

    /**
     * Dress 엔티티 수정 메서드입니다.
     * @param dressName 옷 이름
     * @param dressType 옷 종류
     * @param dressImageUrl 옷 대표 이미지 URL
     */
    public void updateDress(String dressName, DressType dressType, String dressImageUrl) {
        this.dressName = dressName;
        this.dressType = dressType;
        this.dressImageUrl = dressImageUrl;
    }

}
