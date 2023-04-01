package OOTD.demo.auth.repository;

import OOTD.demo.auth.RefreshToken;
import OOTD.demo.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByRefreshToken(String refreshToken);
    void deleteByRefreshToken(String refreshToken);
    void deleteAllByExpirationPeriodBefore(LocalDateTime currentTime);
    void deleteAllByUser(User user);

}
