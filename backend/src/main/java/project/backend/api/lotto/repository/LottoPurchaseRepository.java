package project.backend.api.lotto.repository;


import project.backend.api.lotto.domain.LottoPurchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LottoPurchaseRepository extends JpaRepository<LottoPurchase, Integer> {

    List<LottoPurchase> findAllByPurchaseNo(int purchaseNo);
}
