package OOTD.demo.diarydress;

import OOTD.demo.diary.Diary;
import OOTD.demo.dress.Dress;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DiaryDress {

    @Id
    @GeneratedValue
    @Column(name = "diary_dress_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diary_id")
    private Diary diary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dress_id")
    private Dress dress;

    private DiaryDress(Diary diary, Dress dress) {
        this.diary = diary;
        this.dress = dress;
    }

    /**
     * DiaryDress 엔티티를 생성하는 메서드입니다.
     * @param diary Diary 엔티티
     * @param dress Dress 엔티티
     * @return 생성된 DiaryDress 엔티티
     */
    public static DiaryDress createDiaryDress(Diary diary, Dress dress) {
        return new DiaryDress(diary, dress);
    }
}
