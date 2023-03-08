package OOTD.demo.hashtag.service;

import OOTD.demo.hashtag.HashTag;
import OOTD.demo.hashtag.dto.PostHashTagReq;
import OOTD.demo.hashtag.dto.UpdateHashtagReq;
import OOTD.demo.hashtag.repository.HashTagRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class HashTagService {

    private final HashTagRepository hashTagRepository;

    /**
     * 해시태그 생성 메서드입니다.
     * @param req 해시태그 생성 request
     * @return 생성된 엔티티의 ID
     */
    public Long createHashTag(PostHashTagReq req) {
        return hashTagRepository.save(HashTag.createHashTag(req.getName())).getId();
    }

    /**
     * 해시태그 엔티티를 반환하는 메서드입니다.
     * @param name 해시태그의 이름
     * @return 해시태그 엔티티
     */
    public HashTag getHashTag(String name) {
        return hashTagRepository.findByName(name).orElseThrow(IllegalArgumentException::new);
    }

    /**
     * 해시태그 엔티티의 이름을 수정하는 메서드입니다.
     * @param req 변경할 해시태그 정보를 담은 request
     * @return 변경된 엔티티의 ID
     */
    public Long updateHashTag(UpdateHashtagReq req) {
        HashTag findHashTag = hashTagRepository.findById(req.getId()).orElseThrow(IllegalArgumentException::new);
        findHashTag.setName(req.getName());
        return findHashTag.getId();
    }

    /**
     * 해시태그 엔티티를 삭제하는 메서드입니다.
     * @param id 삭제할 해시태그 엔티티의 ID
     */
    public void deleteHashTag(Long id) {
        hashTagRepository.deleteById(id);
    }
}
