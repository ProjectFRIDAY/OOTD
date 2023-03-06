package OOTD.demo.diarylike.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 게시글 좋아요를 추가한 후 반환되는 DTO입니다.
 * @version 1.0.0
 * @author CHO Min Ho
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDiaryLikeRes {
    private Long DiaryLikeId;
}
