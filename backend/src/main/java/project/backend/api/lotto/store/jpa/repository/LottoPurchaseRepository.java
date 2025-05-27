package project.backend.api.lotto.store.jpa.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.backend.api.lotto.store.jpa.jpo.LottoPurchaseJpo;

import java.util.List;

@Repository
public interface LottoPurchaseRepository extends JpaRepository<LottoPurchaseJpo, Integer> {

    List<LottoPurchaseJpo> findAllByOrderByDrwNoDesc(int targetDrawnNo);
}