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
}
