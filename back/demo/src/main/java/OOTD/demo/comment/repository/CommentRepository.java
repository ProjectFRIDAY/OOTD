package OOTD.demo.comment.repository;

import OOTD.demo.comment.Comment;
import OOTD.demo.diary.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
