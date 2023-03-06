package OOTD.demo.dress.repository;

import OOTD.demo.dress.Dress;
import OOTD.demo.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * JPA Dress repository 입니다.
 *
 * @version 1.0.0
 * @author CHO Min Ho
 */
public interface DressRepository extends JpaRepository<Dress, Long> {
    List<Dress> findDressByUser(User user);
    Optional<Dress> findById(Long id);
}
