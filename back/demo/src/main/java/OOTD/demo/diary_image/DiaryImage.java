package OOTD.demo.diary_image;

import OOTD.demo.diary.Diary;
import lombok.Getter;
import javax.persistence.*;

/**
 * 게시글 이미지 엔티티 클래스입니다.
 *
 * @author CHO Min Ho
 * @version 1.0.0
 */
@Entity
@Getter
@Table(name = "DIARY_IMAGE")
public class DiaryImage {
    @Id
    @GeneratedValue
    @Column(name = "diary_image_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diary_id")
    private Diary diary;
    @Column(name = "diary_image_order")
    private int imageOrder;
    @Column(name = "diary_image_url")
    private String imageUrl;

    private DiaryImage(int imageOrder, Diary diary, String imageUrl) {
        this.imageOrder = imageOrder;
        this.diary = diary;
        this.imageUrl = imageUrl;
    }
    protected DiaryImage() { }

    /**
     * DiaryImage 엔티티 생성 메서드입니다,
     * @param imageOrder 해당 이미지의 게시글에서의 순서
     * @param diary 해당 이미지의 게시글
     * @param imageUrl 이미지 URL
     * @return 생성된 DiaryImage 엔티티
     */
    public static DiaryImage createDiaryImage(int imageOrder, Diary diary, String imageUrl) {
        return new DiaryImage(imageOrder, diary, imageUrl);
    }
}
