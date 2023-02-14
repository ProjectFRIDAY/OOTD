package OOTD.demo.hot.repository;

import OOTD.demo.hot.Hot;
import OOTD.demo.hot.dto.HotDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HotRepository extends JpaRepository<Hot, Long> {

}
