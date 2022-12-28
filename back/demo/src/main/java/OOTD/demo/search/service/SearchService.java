package OOTD.demo.search.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import OOTD.demo.search.repository.SearchRepository;
import OOTD.demo.diary.Diary;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class SearchService {

    private final SearchRepository searchRepository;

    // 태그명으로 검색
    public List<Diary> findByTagName(String tagName) {

        // tagName으로 DiaryId를 찾아서 DiaryId로 Diary를 찾아서 반환

        return searchRepository.findByTagName(tagName);
    }

    // 제목으로 검색
    public List<Diary> findByTitle(String title) {

        // title로 DiaryId를 찾아서 DiaryId로 Diary를 찾아서 반환

        return searchRepository.findByDiaryTitle(title);
    }

    // 내용으로 검색
    public List<Diary> findByContent(String userName) {

        // content로 DiaryId를 찾아서 DiaryId로 Diary를 찾아서 반환
        return searchRepository.findByUserName(userName);
    }
}
