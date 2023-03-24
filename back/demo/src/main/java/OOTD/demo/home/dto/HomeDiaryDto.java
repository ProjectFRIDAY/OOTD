package OOTD.demo.home.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class HomeDiaryDto {

    private Integer day;
    private Long diaryId;

    @QueryProjection
    public HomeDiaryDto(Integer day, Long diaryId) {
        this.day = day;
        this.diaryId = diaryId;
    }
}
