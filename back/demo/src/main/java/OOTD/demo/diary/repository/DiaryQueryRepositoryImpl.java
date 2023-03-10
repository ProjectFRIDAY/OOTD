package OOTD.demo.diary.repository;

import OOTD.demo.diary.dto.DiaryDto;
import OOTD.demo.diary.dto.QDiaryDto;
import OOTD.demo.user.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import java.util.List;

import static OOTD.demo.diary.QDiary.diary;
import static OOTD.demo.follow.QFollow.follow;

@RequiredArgsConstructor
public class DiaryQueryRepositoryImpl implements DiaryQueryRepository {

    private final JPAQueryFactory queryFactory;
    private final int ONCE_PAGING_NUMBER = 20;

    @Override
    public List<DiaryDto> findFollowersDiaryByUser(User user, int lastId) {
        return queryFactory
                .select(new QDiaryDto(diary.id, diary.title, diary.content, diary.createTime, diary.lastModifiedTime,
                        diary.user.id))
                .from(diary)
                .join(follow)
                .on(diary.user.id.eq(follow.follower.id).and(follow.followee.id.eq(user.getId())))
                .fetchJoin()
                .where(diary.id.gt(lastId))
                .orderBy(diary.id.asc())
                .limit(ONCE_PAGING_NUMBER)
                .fetch();
    }

    @Override
    public List<DiaryDto> findDiaryByDate(int lastId, int number) {
        return queryFactory
                .select(new QDiaryDto(diary.id, diary.title, diary.content, diary.createTime, diary.lastModifiedTime,
                        diary.user.id))
                .from(diary)
                .where(diary.id.gt(lastId))
                .orderBy(diary.id.asc())
                .limit(number)
                .fetch();
    }
}
