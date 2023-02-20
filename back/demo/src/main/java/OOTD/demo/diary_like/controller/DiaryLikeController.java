package OOTD.demo.diary_like.controller;

import OOTD.demo.diary_like.dto.PostDiaryLikeReq;
import OOTD.demo.diary_like.dto.PostDiaryLikeRes;
import OOTD.demo.diary_like.service.DiaryLikeService;
import OOTD.demo.common.HttpResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 게시글 좋아요 관련 컨트롤러 클래스입니다.
 * @version 1.0.0
 * @author CHO Min Ho
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class DiaryLikeController {

    private final DiaryLikeService diaryLikeService;
    private final HttpResponseUtil httpResponseUtil;

    /**
     * 게시글 좋아요를 생성하는 API입니다.
     * @param dto 좋아요를 누를 게시글 ID
     * @return 생성된 DiaryLike 엔티티의 ID
     */
    @Operation(summary = "게시글 좋아요 생성 API", description = "게시글 좋아요 생성 API 입니다.",
            tags = { "Diary Like Controller" })
    @PostMapping("/api/diary/like/create")
    public ResponseEntity<?> createDiaryLike(@RequestBody PostDiaryLikeReq dto) {

        PostDiaryLikeRes diaryLike = diaryLikeService.createDiaryLike(dto);
        return httpResponseUtil.createOkHttpResponse(diaryLike, "좋아요 요청에 성공했습니다.");
    }

    /**
     * 게시글 좋아요를 삭제하는 API입니다.
     * @param id 삭제할 DiaryLike 엔티티의 ID
     * @return 성공 메시지
     */
    @Operation(summary = "게시글 좋아요 삭제 API", description = "게시글 좋아요 삭제 API 입니다.",
            tags = { "Diary Like Controller" })
    @GetMapping("/api/diary/like/delete/{id}")
    public ResponseEntity<?> deleteDiaryLike(@PathVariable(name = "id") Long id) {

        diaryLikeService.deleteDiaryLike(id);
        return httpResponseUtil.createOkHttpResponse(null, "좋아요 취소에 성공했습니다.");
    }

}
