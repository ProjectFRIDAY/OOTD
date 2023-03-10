package OOTD.demo.comment.service;

import OOTD.demo.auth.service.AuthService;
import OOTD.demo.comment.Comment;
import OOTD.demo.comment.dto.CommentRes;
import OOTD.demo.comment.dto.PostCommentReq;
import OOTD.demo.comment.dto.UpdateCommentReq;
import OOTD.demo.comment.repository.CommentRepository;
import OOTD.demo.diary.Diary;
import OOTD.demo.diary.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CommentService {

    private final CommentRepository commentRepository;
    private final DiaryRepository diaryRepository;
    private final AuthService authService;


    /**
     * Comment 엔티티를 만드는 메서드입니다.
     * @param req Comment 엔티티 생성 관련 request 객체
     * @return 생성된 Comment 엔티티의 id
     */
    public Long createComment(PostCommentReq req) {

        // TODO : hot 테이블 관련 로직 작성

        return commentRepository.save(Comment.createComment(authService.getCurrentLoginUser(),
                diaryRepository.findById(req.getDiaryId()).orElseThrow(IllegalArgumentException::new), req.getContent(),
                getParentComment(req.getParentCommentId()))).getId();
    }

    /**
     * Comment 엔티티를 삭제하는 메서드입니다.
     * @param id 삭제하려는 Comment 엔티티의 id
     */
    public void deleteComment(Long id) {

        deleteComment(commentRepository.findById(id).orElseThrow(IllegalArgumentException::new));
    }

    /**
     * Comment 엔티티를 수정하는 메서드입니다.
     * @param id 수정하려는 Comment 엔티티의 id
     * @param req 수정하려는 Comment 엔티티의 내용
     * @return 수정한 Comment 엔티티의 id
     */
    public Long updateComment(Long id, UpdateCommentReq req) {

        commentRepository.findById(id).orElseThrow(IllegalArgumentException::new).updateComment(req.getContent());
        return id;
    }

    /**
     * 특정 게시글의 댓글 리스트를 반환하는 메서드입니다.
     * @param id 게시글 엔티티 id
     * @return 해당 게시글의 댓글 리스트
     */
    public List<CommentRes> getCommentList(Long id) {

        // TODO : 팔로우 관계 관련 퍼미션 설정

        List<CommentRes> result = new ArrayList<>();

        for (Comment comment : commentRepository.findAllByDiary(diaryRepository.findById(id).orElseThrow(IllegalArgumentException::new))) {
            result.add(CommentRes.of(comment));
        }

        return result;
    }

    /**
     * 특정 게시글의 댓글 수를 반환하는 메서드입니다.
     * @param id 게시글 id
     * @return 해당 게시글의 댓글 수
     */
    public int getCommentCount(Long id) {
        return commentRepository.findAllByDiary(diaryRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new)).size();
    }

    /**
     * 특정 댓글을 삭제할 때, 해당 댓글의 child 댓글을 모두 삭제하는 메서드입니다.
     * @param comment 삭제하려는 Comment 엔티티
     */
    private void deleteComment(Comment comment) {

        List<Comment> childCommentList = commentRepository.findAllByParentComment(comment);

        for (Comment child : childCommentList) {
            deleteComment(child);
        }

        commentRepository.delete(comment);
    }


    /**
     * 해당 id 를 가지는 Comment (부모 Comment) 를 반환합니다.
     * @param id 부모 Comment 의 id
     * @return 부모 Comment 가 없을 경우 null, 있다면 해당 Comment 엔티티
     */
    private Comment getParentComment(Long id) {

        if (id == null) {
            return null;
        }

        return commentRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }
}
