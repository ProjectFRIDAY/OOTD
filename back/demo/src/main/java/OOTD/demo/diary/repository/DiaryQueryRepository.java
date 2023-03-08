package OOTD.demo.diary.repository;

import OOTD.demo.diary.dto.DiaryDto;
import OOTD.demo.user.User;

import java.util.List;

public interface DiaryQueryRepository {

    List<DiaryDto> findFollowersDiaryByUser(User user, int lastId);
    List<DiaryDto> findDiaryByDate(int lastId, int number);

}
