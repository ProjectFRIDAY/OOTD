package OOTD.demo.comment.controller;

import OOTD.demo.comment.dto.PostCommentReq;
import OOTD.demo.comment.dto.UpdateCommentReq;
import OOTD.demo.comment.service.CommentService;
import OOTD.demo.common.HttpResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
@Slf4j
public class CommentController {
    private final HttpResponseUtil httpResponseUtil;
    private final CommentService commentService;

    /**
     * 댓글을 작성하는 메서드입니다.
     * @param request 댓글 작성 관련 request 객체
     * @return 생성된 댓글의 id
     */
    @PostMapping
    @Operation(summary = "댓글 작성")
    public ResponseEntity<?> createComment(@RequestBody @Valid PostCommentReq request) {

        return httpResponseUtil.createOkHttpResponse(commentService.createComment(request),
                "댓글 작성에 성공했습니다");
    }

    /**
     * 특정 게시글의 댓글 리스트를 반환하는 메서드입니다.
     * @param id 게시글의 id
     * @return 해당 게시글의 댓글 리스트
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getCommentList(@PathVariable Long id) {

        return httpResponseUtil.createOkHttpResponse(commentService.getCommentList(id),
                "댓글 목록 조회에 성공했습니다.");
    }

    /**
     * 댓글 1개를 수정하는 메서드입니다.
     * @param id 해당 댓글의 id
     * @param req 수정할 내용이 담긴 request 객체
     * @return 수정된 댓글의 id
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateSingleComment(@PathVariable Long id, @RequestBody @Valid UpdateCommentReq req) {

        return httpResponseUtil.createOkHttpResponse(commentService.updateComment(id, req),
                "댓글 수정에 성공했습니다.");
    }

    /**
     * 댓글 1개를 삭제하는 메서드입니다.
     * @param id 해당 댓글의 id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSingleComment(@PathVariable Long id) {

        commentService.deleteComment(id);
        return httpResponseUtil.createOkHttpResponse(null, "댓글 삭제에 성공했습니다.");
    }

}
