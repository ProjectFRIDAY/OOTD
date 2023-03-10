package OOTD.demo.comment.repository;

import OOTD.demo.comment.Comment;
import OOTD.demo.diary.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByParentComment(Comment comment);
    List<Comment> findAllByDiary(Diary diary);
}
