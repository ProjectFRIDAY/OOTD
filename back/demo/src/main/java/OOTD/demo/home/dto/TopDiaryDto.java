package OOTD.demo.home.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TopDiaryDto {

    private Long id;
    private String name;
    private int wearTimes;

    @QueryProjection
    public TopDiaryDto(Long id, String name, int wearTimes) {
        this.id = id;
        this.name = name;
        this.wearTimes = wearTimes;
    }
}
