package OOTD.demo.hot.service;

import OOTD.demo.hot.Hot;
import OOTD.demo.hot.dto.HotDTO;
import OOTD.demo.hot.repository.HotRepository;
import OOTD.demo.search.dto.SearchDTO;
import OOTD.demo.search.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class HotService {
    private final HotRepository hotRepository;

    /**
     * Hot Diary를 조회하는 메서드입니다.
     * @param
     * @return 해당 게시글의 정보를 담고 있는 DTO
     */
    public List<HotDTO> getHotList() {
        List<Hot> getList = hotRepository.findAll(Sort.by(Sort.Direction.DESC, "weight"));
        Map<Long, HotDTO> hotMap = new LinkedHashMap<>();
        for (Hot hot : getList) {
            Long postId = hot.getPostId();
            HotDTO hotDTO = hotMap.get(postId);
            if (hotDTO == null) {
                hotMap.put(postId, new HotDTO(hot));
            } else {
                hotDTO.setWeight(hotDTO.getWeight() + hot.getWeight());
            }
        }
        return new ArrayList<>(hotMap.values());
    }

    /**
     * Hot table에 데이터를 추가하는 메서드입니다.
     */

    // ex) 1번 게시글에 1번 유저가 좋아요를 누르면
    // Hot table에 1번 게시글에 1번 유저가 좋아요를 눌렀다는 정보를 저장합니다.
    // 이때, weight는 1입니다.
    public void saveData(Hot hot) {
        long count = hotRepository.count();
        if (hot.getWeight() == 5) {
            Optional<Hot> existingHot = hotRepository.findByPostIdAndUserId(hot.getPostId(), hot.getUserId());
            if (existingHot.isPresent()) {
                throw new RuntimeException("Hot already exists for postId=" + hot.getPostId() + " and userId=" + hot.getUserId());
            }
        }

        if (count < 300) {
            // Add new record with auto-generated id
            hotRepository.save(hot);
        } else {
            // Update existing record with smallest id value
            Hot hotRecord = hotRepository.findFirstByOrderByIdAsc();
            hotRecord.setPostId(hot.getPostId());
            hotRecord.setWeight(hot.getWeight());
            hotRecord.setUserId(hot.getUserId());
            hotRepository.save(hotRecord);
        }
    }
}
