package OOTD.demo.home.service;

import OOTD.demo.auth.service.AuthService;
import OOTD.demo.diary.repository.DiaryRepository;
import OOTD.demo.home.dto.HomeRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Home 관련 컨트롤러입니다.
 *
 * @author CHO Min Ho
 */
@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class HomeService {

    private final DiaryRepository diaryRepository;
    private final AuthService authService;

    /**
     * 특정 년월을 기준으로 캘린더에 들어가는 정보를 반환합니다.
     * @param year 년
     * @param month 월
     * @return 해당 월의 캘린더 정보
     */
    public HomeRes getHomeCalender(int year, int month) {

        return new HomeRes(diaryRepository.findHomeDiaryByDate(authService.getCurrentLoginUser(), year, month),
                diaryRepository.findTopDressByDate(authService.getCurrentLoginUser(), year, month));
    }

}
