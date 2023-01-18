package OOTD.demo.dress.repository;

import OOTD.demo.dress.Dress;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA Dress repository 입니다.
 *
 * @version 1.0.0
 * @author CHO Min Ho
 */
public interface DressRepository extends JpaRepository<Dress, Long> {

}
