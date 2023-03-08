package OOTD.demo.dress.dto;

import OOTD.demo.dress.DressType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Dress 엔티티를 수정할 때 사용되는 Request 객체입니다.
 *
 * @author CHO Min Ho
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDressReq {

    @NotNull(message = "Dress id를 입력해주세요!")
    private Long id;

    @NotBlank(message = "옷 이름을 입력해주세요!")
    private String dressName;

    @NotNull(message = "옷 종류를 입력해주세요!")
    private DressType dressType;

    private List<String> hashTag;

}
