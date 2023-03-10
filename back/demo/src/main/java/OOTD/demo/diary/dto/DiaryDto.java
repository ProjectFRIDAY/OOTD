package OOTD.demo.diary.dto;

import OOTD.demo.diary.Diary;
import com.querydsl.core.annotations.QueryProjection;
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
    private LocalDateTime createTime;
    private LocalDateTime lastModifiedTime;
    private Long userId;

    @QueryProjection
    public DiaryDto(Long id, String title, String content, LocalDateTime createTime, LocalDateTime lastModifiedTime, Long userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
        this.lastModifiedTime = lastModifiedTime;
        this.userId = userId;
    }

    public static DiaryDto of(Diary diary) {
        return new DiaryDto(diary.getId(), diary.getTitle(), diary.getContent(), diary.getCreateTime(),
                diary.getLastModifiedTime(), diary.getUser().getId());
    }

}
