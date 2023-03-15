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
import OOTD.demo.hashtag.repository.HashTagRepository;
import OOTD.demo.hashtag.service.HashTagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    private final HashTagRepository hashTagRepository;

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
            Optional<HashTag> findHashTag = hashTagRepository.findByName(tagStr);

            if (findHashTag.isEmpty()) {
                // 기존에 존재하지 않던 해시태그일 경우 새로운 해시태그 생성
                HashTag newHashTag = hashTagRepository.save(HashTag.createHashTag(tagStr));
                dressHashTagRepository.save(DressHashTag.createDressHashTag(dress, newHashTag));

                return dress.getId();
            }

            dressHashTagRepository.save(DressHashTag.createDressHashTag(dress, findHashTag.get()));
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

        Dress findDress = getDress(req.getId());

        fileUploadUtil.deleteFileByUrl(findDress.getDressImageUrl());

        findDress.updateDress(
                req.getDressName(),
                req.getDressType(),
                fileUploadUtil.uploadFile(category, file).getUrl());

        return findDress.getId();

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

    /**
     * 단일 Dress 엔티티를 조회하는 메서드입니다.
     * @param id 해당 Dress 엔티티의 id
     * @return 해당 Dress 엔티티
     */
    public DressRes getSingleDress(Long id) {

        return toResponse(getDress(id));

    }

    /**
     * 단일 Dress 엔티티를 삭제하는 메서드입니다.
     * @param id 해당 Dress 엔티티의 id
     */
    public void deleteSingleDress(Long id) {

        Dress findDress = getDress(id);

        fileUploadUtil.deleteFileByUrl(findDress.getDressImageUrl());
        dressHashTagRepository.deleteAllByDress(findDress);
        fileUploadUtil.deleteFileByName(findDress.getDressImageUrl());
        dressRepository.deleteById(id);

    }

    private Dress getDress(Long id) {

        Dress findDress = dressRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        if (!Objects.equals(findDress.getUser().getId(), authService.getCurrentLoginUser().getId())) {
            throw new IllegalArgumentException("해당 사용자의 dress가 아닙니다!");
        }

        return findDress;
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
