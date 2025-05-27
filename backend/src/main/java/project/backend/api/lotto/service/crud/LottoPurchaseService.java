package project.backend.api.lotto.service.crud;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.backend.api.common.constants.LottoConstants;
import project.backend.api.lotto.store.jpa.LottoPurchaseStore;
import project.backend.api.lotto.domain.LottoPurchase;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class LottoPurchaseService {

    private final LottoPurchaseStore lottoPurchaseStore;
    private final Random random = new Random();

    public void registerPurchaseLotto(LocalDateTime currentDate, int purchaseLottoNo) {
        List<Integer> lottoNumbers = generateRandomLottoNumbers();

        LottoPurchase lottoPurchase = LottoPurchase.builder()
            .purchaseNo(purchaseLottoNo)
            .purchaseNo1(lottoNumbers.get(0))
            .purchaseNo2(lottoNumbers.get(1))
            .purchaseNo3(lottoNumbers.get(2))
            .purchaseNo4(lottoNumbers.get(3))
            .purchaseNo5(lottoNumbers.get(4))
            .purchaseNo6(lottoNumbers.get(5))
            .purchaseDate(currentDate)
            .build();

        lottoPurchaseStore.save(lottoPurchase);
    }

    private List<Integer> generateRandomLottoNumbers() {
        return random.ints(LottoConstants.MIN_LOTTO_NUMBER, LottoConstants.MAX_LOTTO_NUMBER + 1)
            .distinct()
            .limit(6)
            .boxed()
            .sorted()
            .toList();
    }

    public List<LottoPurchase> findAllByOrderByPurchaseIdDesc(int targetDrawnNo) {
        return lottoPurchaseStore.findAllByOrderByPurchaseIdDesc(targetDrawnNo);
    }
}