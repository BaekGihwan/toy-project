package base.backend.api.lotto.service;


import base.backend.api.common.constants.LottoConstants;
import base.backend.api.lotto.domain.LottoPurchase;
import base.backend.api.lotto.repository.LottoBuyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class LottoBuyService {

    private final LottoBuyRepository lottoBuyRepository;

    @Transactional
    public void insertBuyLottoData(LocalDateTime currentDate, int buyLottoDrwNo) {

        LottoPurchase lottoPurchase = new LottoPurchase();
        Random random = new Random();

        // 1 ~ 45 숫자중 6개 랜덤 / 중복제거 / 낮은수부터 정렬
        List<Integer> lottoNumbers = random.ints(LottoConstants.MIN_LOTTO_NUMBER, LottoConstants.MAX_LOTTO_NUMBER)
                .distinct()
                .limit(6)
                .boxed()
                .sorted()
                .toList();

        // 보너스 번호는 1-45 중에서 당첨 번호를 제외한 숫자들 중 하나 가져오기
        int bonusNumber = random.ints(LottoConstants.MIN_LOTTO_NUMBER, LottoConstants.MAX_LOTTO_NUMBER)
                .filter(n -> !lottoNumbers.contains(n))
                .findFirst()
                .orElseThrow();

        // lottoPurchase 엔티티에 넣기
        lottoPurchase.setPurchaseNo(buyLottoDrwNo);
        lottoPurchase.setPurchaseNo1(lottoNumbers.get(0));
        lottoPurchase.setPurchaseNo2(lottoNumbers.get(1));
        lottoPurchase.setPurchaseNo3(lottoNumbers.get(2));
        lottoPurchase.setPurchaseNo4(lottoNumbers.get(3));
        lottoPurchase.setPurchaseNo5(lottoNumbers.get(4));
        lottoPurchase.setPurchaseNo6(lottoNumbers.get(5));
        lottoPurchase.setPurchaseBonusNo(bonusNumber);
        lottoPurchase.setPurchaseDate(currentDate);

        // 하이버네이트 save사용
        lottoBuyRepository.save(lottoPurchase);
    }
}
