package OOTD.demo.auth.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * 회원가입 시 사용되는 Dto 클래스입니다.
 *
 * @author CHO Min Ho
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserReq {
    @Email(message = "이메일을 입력해주세요!")
    private String email;

    @NotEmpty(message = "계정 이름을 입력해주세요!")
    private String accountName;

    @NotEmpty(message = "닉네임을 입력해주세요!")
    private String nickName;

    @NotEmpty(message = "비밀번호를 입력해주세요!")
    private String password;

    @NotNull(message = "생년월일을 입력해주세요!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate userBirth;
}
