package OOTD.demo.dress.dto;

import OOTD.demo.dress.DressType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * Dress 엔티티 Response 객체입니다.
 *
 * @author CHO Min Ho
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DressRes {

    private Long id;

    private String dressName;

    private DressType dressType;

    private List<String> hashTag;

}
