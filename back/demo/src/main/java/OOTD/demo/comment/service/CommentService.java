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
import java.util.List;

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

    @Transactional
    public CommentResponseDTO deleteComment(Long id) {
        // 댓글 삭제, DB에서 삭제하지 않고 isDeleted를 true로 변경
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 댓글이 없습니다. id=" + id));
        comment.setDeleted(true);
        return CommentResponseDTO.of(commentRepository.save(comment));
    }

    @Transactional
    public List<CommentResponseDTO> getCommentList(Long id) {
        // 댓글 리스트 조회
        List<CommentResponseDTO> loadDtoList;
        if (commentRepository.existsByPostId(id)) {
            // 해당 게시글에 댓글이 있을 경우, Delete가 false인 댓글만 조회
            loadDtoList = commentRepository.findAllNotDeletedByPostId(id);
        } else {
            // 해당 게시글에 댓글이 없을 경우, 빈 리스트 반환
            loadDtoList = null;
        }
        return loadDtoList;
    }
}
