package OOTD.demo.search.service;

import OOTD.demo.diary.Diary;
import OOTD.demo.diary.repository.DiaryRepository;
import OOTD.demo.search.dto.SearchDTO;
import OOTD.demo.search.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class SearchService {
    private final SearchRepository searchRepository;

    /**
     * Title을 이용하여 게시글을 검색하는 메서드입니다.
     * @param title 게시글 Title
     * @return 해당 게시글의 정보를 담고 있는 DTO
     */
    public List<SearchDTO> SearchDiaryByTitle(String title, int page) {
        Page<SearchDTO> searchDiaryList;
        if (searchRepository.existsDiaryByTitle(title)) {
            PageRequest pageRequest = PageRequest.of(page, 20, Sort.by("updateDate").descending());
            searchDiaryList = searchRepository.findByTitle(title, pageRequest);
        } else {
            throw new RuntimeException("No matching entries found");
        }
        return searchDiaryList.getContent();
    }

    /**
     * Tag을 이용하여 게시글을 검색하는 메서드입니다.
     * @param tag 게시글 Tag
     * @return 해당 게시글의 정보를 담고 있는 DTO
     */

    /*
    public List<SearchDTO> SearchDiaryByTag(String tag) {
        // 아직 작동 안됨 tag 없음
        Optional<List<SearchDTO>> searchDiaryList = searchRepository.findAllByTag(tag);

        if (searchDiaryList.isEmpty()) {
            // TODO : 예외 처리 시 반환할 공통 메서드 필요
        }

        return searchDiaryList.get();
    }
     */
}
