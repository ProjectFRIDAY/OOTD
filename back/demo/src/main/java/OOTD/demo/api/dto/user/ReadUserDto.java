package OOTD.demo.api.dto.user;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReadUserDto {
    private Long userId;
    private String userName;
    private String userProfileImg;
}
