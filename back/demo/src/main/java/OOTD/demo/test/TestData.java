package OOTD.demo.test;

import OOTD.demo.diary.Diary;
import OOTD.demo.diary.repository.DiaryRepository;
import OOTD.demo.diary_image.repository.DiaryImageRepository;
import OOTD.demo.dress.repository.DressRepository;
import OOTD.demo.user.User;
import OOTD.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.PostConstruct;
import java.time.LocalDate;

import static OOTD.demo.diary.Diary.createPost;
import static OOTD.demo.diary.PublicScope.ALL;
import static OOTD.demo.diary_image.DiaryImage.createDiaryImage;
import static OOTD.demo.dress.Dress.createDress;
import static OOTD.demo.dress.DressType.INNER;
import static OOTD.demo.dress.DressType.OUTER;
import static OOTD.demo.user.User.createUser;

/**
 * 테스트 데이터 삽입 클래스입니다. (출시 시점에 비활성화 예정)
 *
 * @author CHO Min Ho
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class TestData {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.init();
    }

    @Component
    @RequiredArgsConstructor
    static class InitService {
        private final UserRepository userRepository;
        private final DiaryRepository diaryRepository;
        private final DiaryImageRepository diaryImageRepository;
        private final DressRepository dressRepository;

        @Transactional
        public void init() {
            // 1. User Test Data 삽입
            User user1 = userRepository.save(createUser("abcde@gmail.com", "password1234",
                    "account1234", "nickname1234", LocalDate.now().minusDays(20)));
            User user2 = userRepository.save(createUser("zzzzz@gmail.com", "password1234",
                    "account23232", "nicknick", LocalDate.now().minusDays(20)));
            User user3 = userRepository.save(createUser("ccccc@gmail.com", "password1234",
                    "account3333", "nininini", LocalDate.now().minusDays(20)));
            User user4 = userRepository.save(createUser("ddddd@gmail.com", "password1234",
                    "account4444", "ohohohoh", LocalDate.now().minusDays(20)));
            User user5 = userRepository.save(createUser("eeeee@gmail.com", "password1234",
                    "account5555", "bubububu", LocalDate.now().minusDays(20)));


            // 2. Diary Test Data 삽입
            Diary diary1 = diaryRepository.save(createPost("게시글 제목1", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                    ALL, user1));
            Diary diary2 = diaryRepository.save(createPost("게시글 제목2", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                    ALL, user2));
            Diary diary3 = diaryRepository.save(createPost("게시글 제목3", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                    ALL, user3));
            Diary diary4 = diaryRepository.save(createPost("게시글 제목4", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                    ALL, user4));
            Diary diary5 = diaryRepository.save(createPost("게시글 제목5", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                    ALL, user5));


            // 3. Diary Image Test Data 삽입
            diaryImageRepository.save(createDiaryImage("_test1_1674024696036.jpg", 1, diary1,
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test1_1674024696036.jpg"));
            diaryImageRepository.save(createDiaryImage("_test2_1674024696953.jpg", 2, diary1,
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test2_1674024696953.jpg"));
            diaryImageRepository.save(createDiaryImage("_test3_1674024697809.jpg", 3, diary1,
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test3_1674024697809.jpg"));

            diaryImageRepository.save(createDiaryImage("_test1_1674024696036.jpg", 1, diary2,
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test1_1674024696036.jpg"));
            diaryImageRepository.save(createDiaryImage("_test2_1674024696953.jpg", 2, diary2,
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test2_1674024696953.jpg"));
            diaryImageRepository.save(createDiaryImage("_test3_1674024697809.jpg", 3, diary2,
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test3_1674024697809.jpg"));

            diaryImageRepository.save(createDiaryImage("_test1_1674024696036.jpg", 1, diary3,
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test1_1674024696036.jpg"));
            diaryImageRepository.save(createDiaryImage("_test2_1674024696953.jpg", 2, diary3,
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test2_1674024696953.jpg"));
            diaryImageRepository.save(createDiaryImage("_test3_1674024697809.jpg", 3, diary3,
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test3_1674024697809.jpg"));

            diaryImageRepository.save(createDiaryImage("_test1_1674024696036.jpg", 1, diary4,
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test1_1674024696036.jpg"));
            diaryImageRepository.save(createDiaryImage("_test2_1674024696953.jpg", 2, diary4,
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test2_1674024696953.jpg"));
            diaryImageRepository.save(createDiaryImage("_test3_1674024697809.jpg", 3, diary4,
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test3_1674024697809.jpg"));

            diaryImageRepository.save(createDiaryImage("_test1_1674024696036.jpg", 1, diary5,
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test1_1674024696036.jpg"));
            diaryImageRepository.save(createDiaryImage("_test2_1674024696953.jpg", 2, diary5,
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test2_1674024696953.jpg"));
            diaryImageRepository.save(createDiaryImage("_test3_1674024697809.jpg", 3, diary5,
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test3_1674024697809.jpg"));


            // 4. Dress Test Data 삽입
            dressRepository.save(createDress(user1, "아우터1", OUTER, "#아우터",
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test3_1674024697809.jpg"));
            dressRepository.save(createDress(user2, "아우터1", OUTER, "#아우터",
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test3_1674024697809.jpg"));
            dressRepository.save(createDress(user3, "아우터1", OUTER, "#아우터",
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test3_1674024697809.jpg"));
            dressRepository.save(createDress(user4, "아우터1", OUTER, "#아우터",
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test3_1674024697809.jpg"));
            dressRepository.save(createDress(user5, "아우터1", OUTER, "#아우터",
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test3_1674024697809.jpg"));
            dressRepository.save(createDress(user1, "이너1", INNER, "#아우터",
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test3_1674024697809.jpg"));
            dressRepository.save(createDress(user1, "아우터3", OUTER, "#아우터",
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test3_1674024697809.jpg"));

        }
    }
}
