package OOTD.demo.comment.controller;

import OOTD.demo.comment.dto.CommentRequestDTO;
import OOTD.demo.comment.service.CommentService;
import OOTD.demo.common.HttpResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.NOT_ACCEPTABLE;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final HttpResponseUtil httpResponseUtil;
    private final CommentService commentService;

    @PostMapping("/api/comment/create")
    @Operation(summary = "댓글 작성")
    public ResponseEntity<?> createComment(@RequestBody CommentRequestDTO request) {
        try {
            return httpResponseUtil.createOKHttpResponse(commentService.createComment(request), "댓글 작성 성공");
        } catch (Exception e) {
            return httpResponseUtil.createErrorResponse(request,"댓글 작성 실패: " + e.getMessage(), NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/api/comment/delete")
    @Operation(summary = "댓글 삭제")
    public ResponseEntity<?> deleteComment(@RequestParam(value = "commentId") Long commentId) {
        try {
            // TODO : 자신이 쓴 댓글인지 확인하는 로직 필요?
            return httpResponseUtil.createOKHttpResponse(commentService.deleteComment(commentId), "댓글 삭제 성공");
        } catch (Exception e) {
            return httpResponseUtil.createErrorResponse(commentId,"댓글 삭제 실패: " + e.getMessage(), NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/api/comment/read")
    @Operation(summary = "댓글 조회")
    public ResponseEntity<?> readComment(@RequestParam(value = "postId") Long postId) {
        try {
            return httpResponseUtil.createOKHttpResponse(commentService.getCommentList(postId), "댓글 조회 성공");
        } catch (Exception e) {
            return httpResponseUtil.createErrorResponse(postId,"댓글 조회 실패: " + e.getMessage(), NOT_ACCEPTABLE);
        }
    }
}
