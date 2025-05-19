package base.backend.api.lotto.repository;


import base.backend.api.lotto.domain.LottoPurchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LottoBuyRepository extends JpaRepository<LottoPurchase, Integer> {

    List<LottoPurchase> findAllByPurchaseNo(int purchaseNo);
}
