package OOTD.demo.search.repository;

import OOTD.demo.diary.Diary;
import OOTD.demo.search.dto.SearchDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SearchRepository extends JpaRepository<Diary, String> {

    Optional<List<SearchDTO>> findAllByTitle(String title);

    // Optional<List<SearchDTO>> findAllByTag(String tag);

    Page<SearchDTO> findByTitle(String title, Pageable pageable);

    boolean existsDiaryByTitle(String title);
}
