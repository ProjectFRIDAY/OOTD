package OOTD.demo.diary.repository;

import OOTD.demo.diary.dto.DiaryDto;
import OOTD.demo.diary.dto.QDiaryDto;
import OOTD.demo.home.dto.HomeDiaryDto;
import OOTD.demo.home.dto.QHomeDiaryDto;
import OOTD.demo.home.dto.QTopDiaryDto;
import OOTD.demo.home.dto.TopDiaryDto;
import OOTD.demo.user.User;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import java.util.List;

import static OOTD.demo.diary.QDiary.diary;
import static OOTD.demo.diarydress.QDiaryDress.diaryDress;
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

    @Override
    public List<HomeDiaryDto> findHomeDiaryByDate(User user, int year, int month) {
        return queryFactory
                .select(new QHomeDiaryDto(diary.createTime.dayOfMonth(), diary.id))
                .from(diary)
                .where(diary.user.eq(user).and(diary.createTime.year().eq(year).and(diary.createTime.month().eq(month))))
                .orderBy(diary.id.asc())
                .fetch();
    }

    @Override
    public List<TopDiaryDto> findTopDressByDate(User user, int year, int month) {

        StringPath countAlias = Expressions.stringPath("dress_count");

        return queryFactory
                .select(new QTopDiaryDto(diaryDress.dress.id, diaryDress.dress.dressName,
                        diaryDress.dress.dressImageUrl, diaryDress.id.count().as("dress_count")))
                .from(diary)
                .where(diary.user.eq(user).and(diary.createTime.year().eq(year).and(diary.createTime.month().eq(month))))
                .join(diaryDress).on(diary.id.eq(diaryDress.diary.id))
                .groupBy(diaryDress.dress.id)
                .orderBy(countAlias.desc())
                .limit(5)
                .fetch();
    }

}
