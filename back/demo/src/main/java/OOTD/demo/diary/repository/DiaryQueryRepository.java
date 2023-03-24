package OOTD.demo.diary.repository;

import OOTD.demo.diary.dto.DiaryDto;
import OOTD.demo.home.dto.HomeDiaryDto;
import OOTD.demo.home.dto.TopDiaryDto;
import OOTD.demo.user.User;

import java.util.List;

public interface DiaryQueryRepository {

    List<DiaryDto> findFollowersDiaryByUser(User user, int lastId);
    List<DiaryDto> findDiaryByDate(int lastId, int number);
    List<HomeDiaryDto> findHomeDiaryByDate(int year, int month);
    List<TopDiaryDto> findTopDressByDate(int year, int month);

}
