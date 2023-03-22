package OOTD.demo.auth;

import OOTD.demo.user.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "REFRESH_TOKEN")
public class RefreshToken {

    @Id
    @GeneratedValue
    @Column(name = "token_id")
    private Long id;

    @Column(name = "token_value")
    private String refreshToken;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "valid_until")
    private LocalDateTime expirationPeriod;

    private RefreshToken(String refreshToken, User user, LocalDateTime expirationPeriod) {
        this.refreshToken = refreshToken;
        this.user = user;
        this.expirationPeriod = expirationPeriod;
    }

    /**
     * Refresh Token 을 생성하는 메서드입니다.
     * @param user 사용자
     * @param expirationPeriod 유효기간
     * @return 생성된 RefreshToken 객체
     */
    public static RefreshToken createRefreshToken(User user, LocalDateTime expirationPeriod) {
        return new RefreshToken(UUID.randomUUID().toString().substring(0, 20), user, expirationPeriod);
    }

    public void extendExpirationPeriod(LocalDateTime expirationPeriod) {
        this.expirationPeriod = expirationPeriod;
    }

}
