package project.backend.api.lotto.controller;


import project.backend.api.lotto.sdo.LottoDrawnSdo;
import project.backend.api.lotto.sdo.LottoRecommendSdo;
import project.backend.api.lotto.service.LottoPurchaseService;
import project.backend.api.lotto.service.LottoDrawnService;
import project.backend.api.lotto.service.LottoRecommendService;
import project.backend.api.lotto.service.LottoSchedulerService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RestController
public class LottoController {

    private final LottoSchedulerService lottoSchedulerService;
    private final LottoDrawnService lottoDrawnService;
    private final LottoPurchaseService lottoPurchaseService;
    private final LottoRecommendService lottoRecommendService;

    public LottoController(LottoSchedulerService lottoSchedulerService, LottoDrawnService lottoDrawnService, LottoPurchaseService lottoPurchaseService, LottoRecommendService lottoRecommendService) {

        this.lottoSchedulerService = lottoSchedulerService;
        this.lottoDrawnService = lottoDrawnService;
        this.lottoPurchaseService = lottoPurchaseService;
        this.lottoRecommendService = lottoRecommendService;
    }

    // 토요일 21:30에 실행 (cron = "초 분 시 일 월 요일")
    @Scheduled(cron = "* 30 21 * * 6") // 토요일 21시 30분에 가져온다.
    public void getLottoDrawnNumbers() {

        try {
            System.out.println("매주 토요일 21:30 당첨번호 가져오기 실행 중... 현재 시간: " + LocalDateTime.now());
            // 크롤링해서 현재 동행복권의 회차를 가져오기
            int currentLottoDrwNo = lottoSchedulerService.getLottoDrawnNo();

            // 현재 디비에 저장 되어있는 마지막회차 가져오기
            int lastSavedDrwNo = lottoDrawnService.getLastDrawnNo();

            // 디비의 마지막회차가 현재 회차보다 낮으면 디비회차 +1 가져오고
            if(currentLottoDrwNo > lastSavedDrwNo) {
                int getDrwNo = lastSavedDrwNo + 1;
                // api를통해서 당첨번호 가져오기
                LottoDrawnSdo lottoDrawnSdo = lottoSchedulerService.getWinningNumbers(getDrwNo);
                // db에 insert 진행
                lottoDrawnService.insertLottoWinningData(lottoDrawnSdo);
            }

        } catch (Exception e) {
            // 예외 로깅 및 처리
            System.err.println("로또 당첨번호 가져오는 스케쥴러 작업 중 오류 : " + e.getMessage());
            e.printStackTrace(); // 스택 트레이스 출력 추가
        }
    }

    // 데이터는 일요일 오전6시부터 토요일 오전6기준으로 잡고 문자가 가능하다면 문자로 오전7시에 데이터 전송
    @Scheduled(cron = "* * * * * *") // 매1초
    public void buyLotto() {
        LocalDateTime currentDate = LocalDateTime.now();
        int currentDayValue = currentDate.getDayOfWeek().getValue();
        int currentHour = currentDate.getHour();

        // 디비에 저장 되어있는 마지막 당첨번호를 가져온다
        int lastSavedDrwNo = lottoDrawnService.getLastDrawnNo();
        int buyLottoDrwNo = lastSavedDrwNo + 1;

        // 로또 데이터 저장 시장
        // 일요일 06:00 ~ 토요일 20:00 까지 구매 가능
        if ((currentDayValue >= 1 && currentDayValue <= 5) ||   // 월요일부터 금요일까지 전체
            (currentDayValue == 6 && currentHour <= 20) ||      // 토요일 20:00 이전
            (currentDayValue == 7 && currentHour >= 6)) {       // 일요일 06:00 이후
            lottoPurchaseService.insertBuyLottoData(currentDate, buyLottoDrwNo);
        }
    }

    @GetMapping("/api/v1/recommend")
    public List<LottoRecommendSdo> getLottoRecommendNumbers() {
        // 크롤링해서 현재 동행복권의 회차를 가져오기
        int currentLottoDrwNo = lottoSchedulerService.getLottoDrawnNo();
        // 로또번호 추천
        return lottoRecommendService.getLottoRecommendNumbers(currentLottoDrwNo);
    }
}
