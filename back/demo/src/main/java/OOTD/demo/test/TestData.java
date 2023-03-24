package OOTD.demo.test;

import OOTD.demo.auth.dto.CreateUserReq;
import OOTD.demo.auth.service.AuthService;
import OOTD.demo.diary.Diary;
import OOTD.demo.diary.repository.DiaryRepository;
import OOTD.demo.diarydress.DiaryDress;
import OOTD.demo.diarydress.repository.DiaryDressRepository;
import OOTD.demo.diaryimage.repository.DiaryImageRepository;
import OOTD.demo.dress.Dress;
import OOTD.demo.dress.repository.DressHashTagRepository;
import OOTD.demo.dress.repository.DressRepository;
import OOTD.demo.hashtag.HashTag;
import OOTD.demo.hashtag.repository.HashTagRepository;
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
import static OOTD.demo.diarydress.DiaryDress.createDiaryDress;
import static OOTD.demo.diaryimage.DiaryImage.createDiaryImage;
import static OOTD.demo.dress.Dress.createDress;
import static OOTD.demo.dress.DressHashTag.createDressHashTag;
import static OOTD.demo.dress.DressType.TOP;
import static OOTD.demo.dress.DressType.OUTER;
import static OOTD.demo.hashtag.HashTag.createHashTag;
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
        private final AuthService authService;
        private final DiaryRepository diaryRepository;
        private final DiaryImageRepository diaryImageRepository;
        private final DressRepository dressRepository;
        private final HashTagRepository hashTagRepository;
        private final DressHashTagRepository dressHashTagRepository;
        private final DiaryDressRepository diaryDressRepository;

        @Transactional
        public void init() {
            // 1. User Test Data 삽입
            Long userId1 = authService.createUser(new CreateUserReq("abcde@gmail.com", "account1234",
                    "nickname1234", "password1234", LocalDate.now().minusDays(20)));
            Long userId2 = authService.createUser(new CreateUserReq("zzzzz@gmail.com", "account23232",
                    "nicknick", "password1234", LocalDate.now().minusDays(20)));
            Long userId3 = authService.createUser(new CreateUserReq("ccccc@gmail.com", "account3333",
                    "nininini", "password1234", LocalDate.now().minusDays(20)));
            Long userId4 = authService.createUser(new CreateUserReq("ddddd@gmail.com", "account4444",
                    "ohohohoh", "password1234", LocalDate.now().minusDays(20)));
            Long userId5 = authService.createUser(new CreateUserReq("eeeee@gmail.com", "account5555",
                    "bubububu", "password1234", LocalDate.now().minusDays(20)));

            User user1 = userRepository.findById(userId1).orElseThrow(IllegalArgumentException::new);
            User user2 = userRepository.findById(userId2).orElseThrow(IllegalArgumentException::new);
            User user3 = userRepository.findById(userId3).orElseThrow(IllegalArgumentException::new);
            User user4 = userRepository.findById(userId4).orElseThrow(IllegalArgumentException::new);
            User user5 = userRepository.findById(userId5).orElseThrow(IllegalArgumentException::new);


            // 2. Diary Test Data 삽입
            Diary diary1 = diaryRepository.save(createPost("게시글 제목1", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                    ALL, user1));
            Diary diary1_2 = diaryRepository.save(createPost("게시글 제목1222", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                    ALL, user1));
            Diary diary1_3 = diaryRepository.save(createPost("게시글 제목1333", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                    ALL, user1));
            Diary diary1_4 = diaryRepository.save(createPost("게시글 제목1444", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                    ALL, user1));
            Diary diary1_5 = diaryRepository.save(createPost("게시글 제목1555", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                    ALL, user1));
            Diary diary1_6 = diaryRepository.save(createPost("게시글 제목1666", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
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
            Dress dress1 = dressRepository.save(createDress(user1, "아우터1", OUTER,
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test3_1674024697809.jpg"));
            Dress dress1_2 = dressRepository.save(createDress(user1, "아우터1_2", OUTER,
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test3_1674024697809.jpg"));
            Dress dress1_3 = dressRepository.save(createDress(user1, "아우터1_3", OUTER,
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test3_1674024697809.jpg"));
            Dress dress1_4 = dressRepository.save(createDress(user1, "아우터1_4", OUTER,
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test3_1674024697809.jpg"));
            Dress dress1_5 = dressRepository.save(createDress(user1, "아우터1_5", OUTER,
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test3_1674024697809.jpg"));


            Dress dress2 = dressRepository.save(createDress(user2, "아우터1", OUTER,
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test3_1674024697809.jpg"));
            Dress dress3 = dressRepository.save(createDress(user3, "아우터1", OUTER,
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test3_1674024697809.jpg"));
            Dress dress4 = dressRepository.save(createDress(user4, "아우터1", OUTER,
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test3_1674024697809.jpg"));
            Dress dress5 = dressRepository.save(createDress(user5, "아우터1", OUTER,
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test3_1674024697809.jpg"));
            Dress dress6 = dressRepository.save(createDress(user1, "이너1", TOP,
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test3_1674024697809.jpg"));
            Dress dress7 = dressRepository.save(createDress(user1, "아우터3", OUTER,
                    "https://ootd-s3-bucket.s3.ap-northeast-2.amazonaws.com/diary/_test3_1674024697809.jpg"));

            // 5. Hash Tag 삽입
            HashTag tag1 = hashTagRepository.save(createHashTag("OUTER"));
            HashTag tag2 = hashTagRepository.save(createHashTag("INNER"));
            HashTag tag3 = hashTagRepository.save(createHashTag("CARDIGAN"));
            HashTag tag4 = hashTagRepository.save(createHashTag("JACKET"));
            HashTag tag5 = hashTagRepository.save(createHashTag("SKIRT"));
            HashTag tag6 = hashTagRepository.save(createHashTag("PANTS"));

            // 6. Dress Hash Tag 삽입
            dressHashTagRepository.save(createDressHashTag(dress1, tag1));
            dressHashTagRepository.save(createDressHashTag(dress1, tag2));
            dressHashTagRepository.save(createDressHashTag(dress2, tag1));
            dressHashTagRepository.save(createDressHashTag(dress2, tag2));
            dressHashTagRepository.save(createDressHashTag(dress2, tag3));
            dressHashTagRepository.save(createDressHashTag(dress3, tag1));
            dressHashTagRepository.save(createDressHashTag(dress4, tag1));
            dressHashTagRepository.save(createDressHashTag(dress5, tag1));


            // 7. DiaryDress 삽입
            diaryDressRepository.save(createDiaryDress(diary1, dress1));
            diaryDressRepository.save(createDiaryDress(diary1, dress1_2));
            diaryDressRepository.save(createDiaryDress(diary1, dress1_3));

            diaryDressRepository.save(createDiaryDress(diary1_2, dress1));
            diaryDressRepository.save(createDiaryDress(diary1_3, dress1));
            diaryDressRepository.save(createDiaryDress(diary1_4, dress1));
            diaryDressRepository.save(createDiaryDress(diary1_5, dress1));
            diaryDressRepository.save(createDiaryDress(diary1_6, dress1));

            diaryDressRepository.save(createDiaryDress(diary1_2, dress1));
            diaryDressRepository.save(createDiaryDress(diary1_3, dress1_2));
            diaryDressRepository.save(createDiaryDress(diary1_4, dress1_3));

            diaryDressRepository.save(createDiaryDress(diary1_2, dress1_5));
            diaryDressRepository.save(createDiaryDress(diary1_3, dress1_4));
            diaryDressRepository.save(createDiaryDress(diary1_4, dress1_4));
            diaryDressRepository.save(createDiaryDress(diary1_5, dress1_3));


        }
    }
}
