package OOTD.demo.diary.dto;

import com.querydsl.core.annotations.QueryProjection;
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
@NoArgsConstructor
public class DiaryDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Long userId;

    @QueryProjection
    public DiaryDto(Long id, String title, String content, LocalDateTime createDate, LocalDateTime updateDate, Long userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.userId = userId;
    }

}
