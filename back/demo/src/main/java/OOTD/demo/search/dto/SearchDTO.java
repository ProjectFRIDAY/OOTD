package OOTD.demo.search.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * 검색결과 DTO입니다.
 * @version 1.0.0
 * @author CHO Tae Wan
 */
@Getter
@Setter
public class SearchDTO {
    private ArrayList<String> DiaryTitle;
}
