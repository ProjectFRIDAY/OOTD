package OOTD.demo.diary.dto;

import OOTD.demo.comment.dto.CommentRes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class SingleDiaryRes {

    private DiaryDto diary;

    private int likeCount;

    private List<CommentRes> commentList;
}
