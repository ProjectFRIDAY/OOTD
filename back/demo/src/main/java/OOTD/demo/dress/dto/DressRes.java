package OOTD.demo.dress.dto;

import OOTD.demo.dress.Dress;
import OOTD.demo.dress.DressHashTag;
import OOTD.demo.dress.DressType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Dress 엔티티 Response 객체입니다.
 *
 * @author CHO Min Ho
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DressRes implements Comparable<DressRes> {

    private Long id;
    private String dressName;
    private DressType dressType;
    private String imageUrl;
    private List<String> hashTag;

    public static DressRes of(Dress dress, List<DressHashTag> hashTagList) {
        return new DressRes(dress.getId(), dress.getDressName(), dress.getDressType(), dress.getDressImageUrl(),
                hashTagList
                        .stream()
                        .map(hashTag -> hashTag.getHashTag().getName())
                        .collect(Collectors.toList())
        );
    }

    @Override
    public int compareTo(DressRes dressRes) {

        return this.id.compareTo(dressRes.id);
    }
}
