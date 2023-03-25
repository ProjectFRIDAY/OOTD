package OOTD.demo.profile.dto;

import OOTD.demo.diary.Diary;
import OOTD.demo.diaryimage.DiaryImage;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ProfileDTO {
    private Long userId;
    private String userName;
    private String userProfileImg;
    private int followerCount;
    private int followingCount;
    private List<Diary> diaryList;
}
