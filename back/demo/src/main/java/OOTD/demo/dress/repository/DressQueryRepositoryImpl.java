package OOTD.demo.dress.repository;

import OOTD.demo.dress.Dress;
import OOTD.demo.user.User;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static OOTD.demo.dress.QDress.dress;
import static OOTD.demo.dress.QDressHashTag.dressHashTag;
import static OOTD.demo.hashtag.QHashTag.hashTag;

@RequiredArgsConstructor
public class DressQueryRepositoryImpl implements DressQueryRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public Set<Dress> findDressByNameAndHashTag(User user, String searchStr) {

        Set<Dress> findDressByNameList = new HashSet<>(
                queryFactory
                        .select(dress)
                        .from(dress)
                        .where(dress.user.eq(user).and(dress.dressName.contains(searchStr)))
                        .distinct()
                        .fetch());

        Set<Dress> findDressByTagList = new HashSet<>(
                queryFactory
                        .select(dress)
                        .from(dress)
                        .join(dressHashTag).on(dress.id.eq(dressHashTag.dress.id))
                        .fetchJoin()
                        .join(hashTag).on(dressHashTag.hashTag.id.eq(hashTag.id))
                        .fetchJoin()
                        .where(dress.user.eq(user).and(hashTag.name.contains(searchStr)))
                        .distinct()
                        .fetch());

        findDressByNameList.addAll(findDressByTagList);
        return findDressByNameList;

    }
}
