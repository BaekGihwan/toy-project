package project.backend.api.lotto.repository;


import project.backend.api.lotto.domain.LottoRecommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LottoRecommendRepository extends JpaRepository<LottoRecommend, Integer> {

//    List<LottoRecommend> findAllbyPurchaseNo(int purchaseNo);
}
