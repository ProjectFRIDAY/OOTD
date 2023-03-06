package OOTD.demo.dress.service;

import OOTD.demo.auth.service.AuthService;
import OOTD.demo.dress.Dress;
import OOTD.demo.dress.DressHashTag;
import OOTD.demo.dress.dto.DressRes;
import OOTD.demo.dress.dto.PostDressReq;
import OOTD.demo.dress.dto.UpdateDressReq;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    private final String category = "dress";

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
                req.getDressType(), fileUploadUtil.uploadFile(category, file).getUrl()));

        // 해시태그 생성
        for (String tagStr : req.getHashTag()) {
            HashTag findHashTag = hashTagService.getHashTag(tagStr);
            dressHashTagRepository.save(DressHashTag.createDressHashTag(dress, findHashTag));
        }

        return dress.getId();
    }

    /**
     * Dress 엔티티를 수정하는 메서드입니다.
     * @param req Dress 정보를 담은 request 객체
     * @param file 대표 사진
     * @return 수정된 Dress 객체의 ID
     */
    public Long updateDress(UpdateDressReq req, MultipartFile file) {

        Optional<Dress> findDress = dressRepository.findById(req.getId());

        if (findDress.isEmpty()) {
            // TODO : 공통 예외처리 로직
        }

        fileUploadUtil.deleteFile(findDress.get().getDressImageUrl());

        findDress.get().updateDress(
                req.getDressName(),
                req.getDressType(),
                fileUploadUtil.uploadFile(category, file).getUrl());

        return findDress.get().getId();

    }

    /**
     * 로그인한 사용자의 Dress 리스트를 조회하는 메서드입니다.
     *
     * @return 현재 로그인한 사용자의 Dress 리스트
     */
    public List<DressRes> getDressList() {

        List<Dress> findDressList = dressRepository.findDressByUser(authService.getCurrentLoginUser());
        List<DressRes> result = new ArrayList<>();

        for (Dress dress : findDressList) {
            result.add(toResponse(dress));
        }

        return result;

    }

    private DressRes toResponse(Dress dress) {

        List<DressHashTag> findHashTagList = dressHashTagRepository.findByDress(dress);
        List<String> hashTagList = new ArrayList<>();

        for (DressHashTag dressHashTag : findHashTagList) {
            hashTagList.add(dressHashTag.getHashTag().getName());
        }

        return new DressRes(dress.getId(),
                dress.getDressName(),
                dress.getDressType(),
                hashTagList
                );
    }

}
