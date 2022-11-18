package OOTD.demo.file.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 파일 업로드 테스트 컨트롤러의 삭제 메서드를 위한 DTO입니다.
 * @version 1.0.0
 * @author CHO Min Ho
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteFileReqDTO {
    private String fileUrl;
}
