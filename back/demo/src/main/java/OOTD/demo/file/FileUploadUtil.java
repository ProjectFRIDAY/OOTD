package OOTD.demo.file;

import OOTD.demo.file.dto.FileDto;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;

/**
 * 파일 업로드 관련 Util 클래스입니다.
 * @version 1.0.0
 * @author CHO Min Ho
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class FileUploadUtil {
    /**
     * AWS S3 bucket 이름
     */
    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;

    /**
     * AWS S3 Client 객체
     * AWS S3 서버와 통신합니다.
     */
    private final AmazonS3Client amazonS3Client;

    /**
     * 파일 확장자는 .으로 구분합니다.
     */
    private static final String FILE_EXTENSION_SEPARATOR = ".";
    /**
     * 파일 카테고리는 /으로 구분합니다.
     */
    private static final String CATEGORY_PREFIX = "/";
    /**
     * 파일 생성일자는 _으로 구분합니다.
     */
    private static final String TIME_SEPARATOR = "_";

    /**
     * 파일과 해당 파일의 유형을 넘겨받아, AWS S3 bucket에 저장하고, 저장된 파일에 접근하는 URL을 반환합니다.
     * 저장된 파일은 project/사진이름_1452152.jpg 와 같은 형식으로 작명됩니다.
     * @param category 파일의 유형
     * @param multipartFile 넘겨받은 multipartFile (파일)
     * @return 업로드된 파일의 접근 URL
     */
    public FileDto uploadFile(String category, MultipartFile multipartFile) {
        if (multipartFile == null || multipartFile.isEmpty()) {
            return null;
        }
        validateFileExists(multipartFile);

        String fileName = buildFileName(category, multipartFile.getOriginalFilename());

        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(multipartFile.getContentType());

        try (InputStream inputStream = multipartFile.getInputStream()) {
            amazonS3Client.putObject(new PutObjectRequest(bucketName, fileName, inputStream, objectMetadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead));
        } catch (IOException e) {
            // TODO : 공통 예외 처리 로직 필요
            e.printStackTrace();
        }

        return new FileDto(fileName, amazonS3Client.getUrl(bucketName, fileName).toString());
    }

    /**
     * S3 bucket에서 특정 파일을 이름을 기준으로 삭제합니다.
     * @param fileName 삭제할 파일 이름
     */
    public void deleteFileByName(String fileName) {
        amazonS3Client.deleteObject(new DeleteObjectRequest(bucketName, fileName));
    }

    /**
     * S3 bucket에서 특정 파일을 URL을 기준으로 삭제합니다.
     * @param url 삭제할 파일 URL
     */
    public void deleteFileByUrl(String url) {
        amazonS3Client.deleteObject(new DeleteObjectRequest(bucketName, getFileNameFromUrl(url)));
    }

    /**
     * 빈 파일일 경우, BaseException을 던집니다.
     * @param multipartFile 넘겨받은 multipartFile (파일)
     */
    private void validateFileExists(MultipartFile multipartFile) {
        if (multipartFile.isEmpty()) {
            // TODO : 빈 파일이 넘어왔을 때의 에외 처리 로직 필요
        }
    }

    /**
     * 파일의 유형, 이름, 현재 시간을 이용해서 저장된 파일 이름을 작명하고, 작명된 이름을 반환합니다.
     * @param category 파일의 유형
     * @param originalFileName 파일의 이름
     * @return 작명된 파일 이름
     */
    private String buildFileName(String category, String originalFileName) {
        int fileExtensionIndex = originalFileName.lastIndexOf(FILE_EXTENSION_SEPARATOR);
        String fileExtension = originalFileName.substring(fileExtensionIndex);
        String fileName = originalFileName.substring(0, fileExtensionIndex);
        String now = String.valueOf(System.currentTimeMillis());

        return category + CATEGORY_PREFIX + fileName + TIME_SEPARATOR + now + fileExtension;
    }

    /**
     * 객체 접근 URL 로부터 파일 이름을 반환합니다.
     * @param url 파일 접근 URL
     * @return 파일 이름
     */
    private String getFileNameFromUrl(String url) {
        String baseUrl = "https://" + bucketName + ".s3.ap-northeast-2.amazonaws.com";
        return url.substring(baseUrl.length());
    }
}
