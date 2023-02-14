package OOTD.demo.hot.service;

import OOTD.demo.hot.Hot;
import OOTD.demo.hot.dto.HotDTO;
import OOTD.demo.hot.repository.HotRepository;
import OOTD.demo.search.dto.SearchDTO;
import OOTD.demo.search.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        List<Hot> getList = hotRepository.findAll();
        List<HotDTO> HotList = new ArrayList<>();
        for (Hot hot : getList) {
            HotList.add(new HotDTO(hot));
        }
        return HotList;
    }
}
