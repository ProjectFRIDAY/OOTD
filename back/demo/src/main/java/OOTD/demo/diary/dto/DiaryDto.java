package OOTD.demo.diary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 게시글 정보 조회 시 사용되는 DTO입니다.
 * @version 1.0.0
 * @author CHO Min HO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiaryDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Long userId;
}
