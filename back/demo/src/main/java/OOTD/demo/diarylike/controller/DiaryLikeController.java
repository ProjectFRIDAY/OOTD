package OOTD.demo.diarylike.controller;

import OOTD.demo.diarylike.dto.PostDiaryLikeReqDTO;
import OOTD.demo.diarylike.dto.PostDiaryLikeResDTO;
import OOTD.demo.diarylike.service.DiaryLikeService;
import OOTD.demo.domain.HttpResponseUtil;
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
    @PostMapping("/api/diary/like/create")
    public ResponseEntity<?> createDiaryLike(@RequestBody PostDiaryLikeReqDTO dto) {

        // TODO : 현재 로그인된 사용자를 불러오는 로직 필요

        PostDiaryLikeResDTO diaryLike = diaryLikeService.createDiaryLike(dto, null);
        return httpResponseUtil.createOKHttpResponse(diaryLike, "좋아요 요청에 성공했습니다.");
    }

    /**
     * 게시글 좋아요를 삭제하는 API입니다.
     * @param id 삭제할 DiaryLike 엔티티의 ID
     * @return 성공 메시지
     */
    @GetMapping("/api/diary/like/delete/{id}")
    public ResponseEntity<?> deleteDiaryLike(@PathVariable(name = "id") Long id) {

        // TODO : 현재 로그인된 사용자를 불러오는 로직 필요

        diaryLikeService.deleteDiaryLike(id, null);
        return httpResponseUtil.createOKHttpResponse(null, "좋아요 취소에 성공했습니다.");
    }

}
