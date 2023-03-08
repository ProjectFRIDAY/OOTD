package OOTD.demo.search.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchDTO{
    String title;
    String content;
    String createDate;
    String updateDate;
    String userId;
}
