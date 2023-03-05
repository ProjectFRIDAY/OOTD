package OOTD.demo.dress.service;

import OOTD.demo.auth.service.AuthService;
import OOTD.demo.dress.Dress;
import OOTD.demo.dress.DressHashTag;
import OOTD.demo.dress.dto.PostDressReq;
import OOTD.demo.dress.repository.DressHashTagRepository;
import OOTD.demo.dress.repository.DressRepository;
import OOTD.demo.file.FileUploadUtil;
import OOTD.demo.hashtag.HashTag;
import OOTD.demo.hashtag.service.HashTagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * Dress 관련 서비스 클래스입니다.
 *
 * @author CHO Min Ho
 */
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class DressService {

    private final DressRepository dressRepository;
    private final AuthService authService;
    private final FileUploadUtil fileUploadUtil;
    private final DressHashTagRepository dressHashTagRepository;
    private final HashTagService hashTagService;

    /**
     * Dress 엔티티를 생성하는 메서드입니다.
     * @param req Dress 정보를 담은 request 객체
     * @param file 대표 사진
     * @return 생성된 Dress 객체의 ID
     */
    public Long createDress(PostDressReq req, MultipartFile file) {

        Dress dress = dressRepository.save(Dress.createDress(authService.getCurrentLoginUser(), req.getDressName(),
                req.getDressType(), fileUploadUtil.uploadFile("dress", file).getUrl()));

        // 해시태그 생성
        for (String tagStr : req.getHashTag()) {
            HashTag findHashTag = hashTagService.getHashTag(tagStr);
            dressHashTagRepository.save(DressHashTag.createDressHashTag(dress, findHashTag));
        }

        return dress.getId();
    }

}
