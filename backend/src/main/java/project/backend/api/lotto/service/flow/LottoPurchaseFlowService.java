package project.backend.api.lotto.service.flow;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.backend.api.lotto.domain.LottoDrawn;
import project.backend.api.lotto.service.crud.LottoDrawnService;
import project.backend.api.lotto.service.crud.LottoPurchaseService;

import java.time.LocalDateTime;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class LottoPurchaseFlowService {

    private final LottoDrawnService lottoDrawnService;
    private final LottoPurchaseService lottoPurchaseService;

    public void registerPurchaseLotto() {
        LocalDateTime currentDate = LocalDateTime.now();
        int currentDayValue = currentDate.getDayOfWeek().getValue();
        int currentHour = currentDate.getHour();

        // 현재 디비에 저장 되어있는 마지막회차 가져오기
        LottoDrawn lottoDrawn = lottoDrawnService.getLastDrawnNo();
        int purchaseLottoNo = lottoDrawn.getDrwNo() + 1;

        // 로또 데이터 저장 시장
        // 일요일 06:00 ~ 토요일 20:00 까지 구매 가능
        if ((currentDayValue >= 1 && currentDayValue <= 5) ||   // 월요일부터 금요일까지 전체
                (currentDayValue == 6 && currentHour <= 20) ||      // 토요일 20:00 이전
                (currentDayValue == 7 && currentHour >= 6)) {       // 일요일 06:00 이후
            lottoPurchaseService.registerPurchaseLotto(currentDate, purchaseLottoNo);
        }
    }
}
