package OOTD.demo.file.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 파일의 정보를 담고 있는 Dto 클래스입니다.
 *
 * @author CHO Min Ho
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FileDto {
    String name;
    String url;
}
