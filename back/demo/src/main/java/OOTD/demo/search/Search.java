package OOTD.demo.search;

import OOTD.demo.diary.dto.PostDiaryResDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * TagName, DiaryTitle, UserName을 검색하는 서비스 클래스입니다.
 * @version 1.0.0
 * @author CHO Tae Wan
 */
public class Search {
    private String tagName;
    private String diaryTitle;
    private String userName;
    public Search(String tagName, String diaryTitle, String userName) {
        this.tagName = tagName;
        this.diaryTitle = diaryTitle;
        this.userName = userName;
    }
    public String getTagName() {
        return tagName;
    }
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
    public String getDiaryTitle() {
        return diaryTitle;
    }
    public void setDiaryTitle(String diaryTitle) {
        this.diaryTitle = diaryTitle;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
