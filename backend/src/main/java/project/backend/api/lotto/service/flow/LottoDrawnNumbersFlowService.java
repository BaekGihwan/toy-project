package project.backend.api.lotto.service.flow;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.backend.api.lotto.domain.LottoDrawn;
import project.backend.api.lotto.sdo.LottoDrawnSdo;
import project.backend.api.lotto.service.crud.LottoApiService;
import project.backend.api.lotto.service.crud.LottoCrawlingService;
import project.backend.api.lotto.service.crud.LottoDrawnService;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class LottoDrawnNumbersFlowService {

    private final LottoCrawlingService lottoCrawlingService;
    private final LottoApiService lottoApiService;
    private final LottoDrawnService lottoDrawnService;

    public void getLottoDrawnNumbers() {

        // 크롤링해서 현재 동행복권의 회차를 가져오기
        int currentLottoDrwNo = lottoCrawlingService.getLottoDrawnNo();

        // 현재 디비에 저장 되어있는 마지막회차 가져오기
        LottoDrawn lottoDrawn = lottoDrawnService.getLastDrawnNo();

        // 디비의 마지막회차가 현재 회차보다 낮으면 디비회차+1 해서 동행복권 api를 통해서 당첨번호 가져옴
        if(currentLottoDrwNo > lottoDrawn.getDrwNo()) {
            int targetDrawnNo = lottoDrawn.getDrwNo() + 1;
            LottoDrawnSdo lottoDrawnSdo = lottoApiService.getLottoDrawnNumbers(targetDrawnNo);

            // DB에 insert 진행
            lottoDrawnService.registerLottoDrawnNumbers(lottoDrawnSdo);
        }
    }
}
