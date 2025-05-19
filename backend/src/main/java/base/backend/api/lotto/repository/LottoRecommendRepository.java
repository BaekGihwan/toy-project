package base.backend.api.lotto.repository;


import base.backend.api.lotto.domain.LottoRecommend;
import base.backend.api.lotto.sdo.LottoRecommendSdo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LottoRecommendRepository extends JpaRepository<LottoRecommend, Integer> {

//    List<LottoRecommend> findAllbyPurchaseNo(int purchaseNo);
}
