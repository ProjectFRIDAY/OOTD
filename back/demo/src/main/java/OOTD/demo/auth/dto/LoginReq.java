package OOTD.demo.auth.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class LoginReq {
    @NotEmpty(message = "이메일을 입력해주세요!")
    private String email;

    @NotEmpty(message = "비밀번호를 입력해주세요!")
    private String password;
}
