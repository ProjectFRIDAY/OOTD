package OOTD.demo.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CheckNameRes
{
    @NotEmpty(message = "닉네임을 입력해주세요!")
    private String name;
}
