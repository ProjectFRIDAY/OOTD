package OOTD.demo.api.dto.auth;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateUserDto {
    private String email;
    private String password;
    private String fcm_access_token;
    private String userName;
    private LocalDate userBirth;
}
