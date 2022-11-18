package OOTD.demo.user.dto;


import OOTD.demo.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateUserDto {
    private String userName;
    private String userProfileImg;
    public UpdateUserDto(User user){
        this.userName = user.getName();
        this.userProfileImg = user.getProfileImg();
    }
}
