package project.backend.api.lotto.store.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.backend.api.lotto.store.jpa.jpo.LottoRecommendJpo;

@Repository
public interface LottoRecommendRepository extends JpaRepository<LottoRecommendJpo, Integer> {
} 