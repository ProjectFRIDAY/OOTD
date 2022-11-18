package OOTD.demo.repository.user;

import OOTD.demo.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existByName(String name);
    Optional<User> findByEmailAndBirth(String email, LocalDate birth);

}
