package OOTD.demo.comment.service;

import OOTD.demo.comment.Comment;
import OOTD.demo.comment.dto.CommentRequestDTO;
import OOTD.demo.comment.dto.CommentResponseDTO;
import OOTD.demo.comment.repository.CommentRepository;
import OOTD.demo.hot.Hot;
import OOTD.demo.hot.service.HotService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final HotService hotService;
    private final CommentRepository commentRepository;
    @Transactional
    public CommentResponseDTO createComment(CommentRequestDTO request) {
        // 댓글 작성
        Comment comment = Comment.builder()
                .postId(request.getPostId())
                .userId(request.getUserId())
                .content(request.getContent())
                .createdDate(LocalDateTime.now())
                .isDeleted(false)
                .build();
        // 댓글 작성 시, hot 테이블에도 추가
        Hot hot = Hot.builder()
                .postId(request.getPostId())
                .userId(request.getUserId())
                .weight(5)
                .build();
        hotService.saveData(hot);
        return CommentResponseDTO.of(commentRepository.save(comment));
    }
}
