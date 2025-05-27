package project.backend.api.lotto.store.jpa.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.backend.api.lotto.store.jpa.jpo.LottoDrawnJpo;

import java.util.List;
import java.util.Optional;

@Repository
public interface LottoDrawnRepository extends JpaRepository<LottoDrawnJpo, Integer> {

    Optional<LottoDrawnJpo> findTopByOrderByDrwNoDesc();

    List<LottoDrawnJpo> findAllByOrderByDrwNoDesc();
}