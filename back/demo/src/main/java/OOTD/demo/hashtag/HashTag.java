package OOTD.demo.hashtag;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 해시태그 엔티티입니다.
 *
 * @author CHO Min Ho
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HashTag {

    @Id
    @GeneratedValue
    @Column(name = "tag_id")
    private Long id;

    @Column(name = "tag_name", nullable = false)
    private String name;

    private HashTag(String name) {
        this.name = name;
    }

    /**
     * 해시태그 생성 메서드입니다.
     * @param name 해시태그 이름
     * @return 생성된 해시태그 엔티티
     */
    public static HashTag createHashTag(String name) {
        return new HashTag(name);
    }
}
