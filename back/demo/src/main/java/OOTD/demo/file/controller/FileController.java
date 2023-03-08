package OOTD.demo.file.controller;

import OOTD.demo.file.FileUploadUtil;
import OOTD.demo.file.dto.DeleteFileReq;
import OOTD.demo.file.dto.UploadFileReq;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 파일 업로드 테스트 컨트롤러입니다. (실제로는 각 요청마다 파일이 넘어오므로 이렇게 파일만을 넘길 일이 없습니다.)
 * @version 1.0.0
 * @author CHO Min Ho
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class FileController {

    private final FileUploadUtil fileUploadUtil;

    /**
     * 파일을 업로드하는 메서드입니다.
     * @param dto 파일의 유형, 실제 파일을 담고 있는 DTO
     * @return 저장된 파일의 URL
     */
    @Operation(summary = "(테스트용) 파일 업로드 API", description = "파일 업로드 API 입니다. (테스트용)",
            tags = { "Test Controller" })
    @PostMapping("/test/file/upload")
    public String uploadSingleFile(@RequestPart UploadFileReq dto, @RequestPart MultipartFile file) {
        return fileUploadUtil.uploadFile(dto.getCategory(), file).getUrl();
    }

    /**
     * 업로드한 파일을 삭제하는 메서드입니다.
     * @param dto 삭제할 파일의 URL을 담고 있는 dto
     * @return 삭제 성공 메시지
     */
    @Operation(summary = "(테스트용) 파일 삭제 API", description = "파일 삭제 API 입니다. (테스트용)",
            tags = { "Test Controller" })
    @PostMapping("/test/file/delete")
    public String deleteSingleFile(@RequestBody DeleteFileReq dto) {
        fileUploadUtil.deleteFileByName(dto.getFileUrl());
        return "success";
    }
}
