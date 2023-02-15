package OOTD.demo.diary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDiaryReq {
    @NotNull(message = "Diary ID를 입력해주세요!")
    private Long id;
    @NotBlank(message = "제목을 입력해주세요!")
    private String title;
    @NotBlank(message = "내용을 입력해주세요!")
    private String content;
}
