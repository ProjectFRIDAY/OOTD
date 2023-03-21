package OOTD.demo.profile.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProfileDTO {
    private Long userId;
    private String userName;
    private String userProfileImg;
    private int followerCount;
    private int followingCount;

    // TODO : 프로필에 띄울 게시글?
}
