package OOTD.demo.hot.dto;

import OOTD.demo.hot.Hot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotDTO {
    private Long id;
    private int weight;
    private Long userId;

    public HotDTO(Hot hot) {
        this.id = hot.getId();
        this.weight = hot.getWeight();
        this.userId = hot.getUserId();
    }
}
