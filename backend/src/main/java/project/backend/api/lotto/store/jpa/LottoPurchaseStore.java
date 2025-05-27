package project.backend.api.lotto.store.jpa;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.backend.api.lotto.domain.LottoPurchase;
import project.backend.api.lotto.store.jpa.jpo.LottoPurchaseJpo;
import project.backend.api.lotto.store.jpa.repository.LottoPurchaseRepository;

import java.util.List;

@Transactional(readOnly = true)
@Repository
@RequiredArgsConstructor
public class LottoPurchaseStore {

    private final LottoPurchaseRepository lottoPurchaseRepository;

    public void save(LottoPurchase  lottoPurchase) {
        lottoPurchaseRepository.save(new LottoPurchaseJpo(lottoPurchase));
    }

    public List<LottoPurchase> findAllByPurchaseNoOrderByPurchaseIdDesc(int purchaseNo) {
        return lottoPurchaseRepository.findAllByPurchaseNoOrderByPurchaseIdDesc(purchaseNo).stream()
            .map(LottoPurchaseJpo::toDomain)
            .toList();
    }
}
