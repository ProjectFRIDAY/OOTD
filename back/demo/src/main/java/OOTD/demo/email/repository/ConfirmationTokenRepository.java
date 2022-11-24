package OOTD.demo.email.repository;

import OOTD.demo.email.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, String> {
    Optional<ConfirmationToken> findByCodeAndExpirationDateAfterAndExpired(String code, LocalDateTime now, boolean expired);
}
