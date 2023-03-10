package OOTD.demo.diary.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Diary 엔티티 정보를 반환할 때 사용하는 Response 객체입니다.
 *
 * @author CHO Min Ho
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MultipleDiaryRes {

    DiaryDto diary;
    int likeCount;
    int commentCount;
}
