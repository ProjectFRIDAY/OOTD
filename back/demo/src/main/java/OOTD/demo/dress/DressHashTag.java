package OOTD.demo.dress;

import OOTD.demo.hashtag.HashTag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DressHashTag {

    @Id
    @GeneratedValue
    @Column(name = "dress_tag_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dress_id")
    private Dress dress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private HashTag hashTag;

    private DressHashTag(Dress dress, HashTag hashTag) {
        this.dress = dress;
        this.hashTag = hashTag;
    }

    /**
     * DressHashTag 엔티티 생성 메서드입니다.
     * @param dress 해당 Dress 엔티티
     * @param hashTag 해당 HashTag 엔티티
     * @return 생성된 DressHashTag 엔티티
     */
    public static DressHashTag createDressHashTag(Dress dress, HashTag hashTag) {
        return new DressHashTag(dress, hashTag);
    }
}
