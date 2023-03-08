package OOTD.demo.diary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 게시글 리스트를 조회할 때 사용하는 response 객체입니다.
 *
 * @author CHO Min Ho
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiaryListRes {

    List<DiaryDto> diaryList;
    boolean isLastDiaryFollowers;

}
