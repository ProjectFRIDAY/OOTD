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
            return httpResponseUtil.createOkHttpResponse(commentService.createComment(request), "댓글 작성 성공");
        } catch (Exception e) {
            return httpResponseUtil.createErrorResponse(request,"댓글 작성 실패: " + e.getMessage(), NOT_ACCEPTABLE);
        }
    }
}
