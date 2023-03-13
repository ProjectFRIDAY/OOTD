package OOTD.demo.user;


import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

/**
 * User 엔티티입니다.
 * TODO : 프로필 이미지 기본으로 설정하는 코드
 *
 * @author CHO Min Ho
 */
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_password")
    private String password;

    @Column(name="user_account_name")
    private String accountName;

    @Column(name = "user_nickname")
    private String nickName;

    @Column(name = "user_birth")
    private LocalDate birth;

    @Column(name = "user_profile_image")
    private String profileImg;


    private User(String email, String password, String accountName, String nickName, LocalDate birth) {
        this.email = email;
        this.password = password;
        this.accountName = accountName;
        this.nickName = nickName;
        this.birth = birth;
    }

    /**
     * User 엔티티를 생성하는 메서드입니다.
     * User 엔티티는 해당 메서드로만 생성됩니다.
     * @return 생성된 User 엔티티
     */
    public static User createUser(String email, String password, String accountName, String nickName, LocalDate birth) {
        return new User(email, password, accountName, nickName, birth);
    }


    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
