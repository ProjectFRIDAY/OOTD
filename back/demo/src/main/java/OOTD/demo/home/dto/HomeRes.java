package OOTD.demo.home.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HomeRes {

    List<HomeDiaryDto> diaryDtoList;
    List<TopDiaryDto> topDiaryDtoList;

}
