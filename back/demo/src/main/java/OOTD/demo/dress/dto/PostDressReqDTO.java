package OOTD.demo.dress.dto;

import OOTD.demo.dress.DressType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Dress 생성 관련 DTO 클래스입니다.
 *
 * @author CHO Min Ho
 * @version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDressReqDTO {
    @NotBlank(message = "옷 이름을 입력해주세요!")
    private String dressName;
    @NotNull(message = "옷 종류를 입력해주세요!")
    private DressType dressType;
}
