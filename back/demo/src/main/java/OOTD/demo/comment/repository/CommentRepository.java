package OOTD.demo.comment.repository;

import OOTD.demo.comment.Comment;
import OOTD.demo.comment.dto.CommentResponseDTO;
import OOTD.demo.diary.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // isDeleted = false인 댓글만 가져오기
    @Query("SELECT p FROM Comment p WHERE p.isDeleted = false AND p.postId = :postId")
    List<CommentResponseDTO> findAllNotDeletedByPostId(@Param("postId") Long postId);
    boolean existsByPostId(Long id);
}
