package base.backend.api.lotto.controller;


import base.backend.api.lotto.sdo.LottoDrawnSdo;
import base.backend.api.lotto.sdo.LottoRecommendSdo;
import base.backend.api.lotto.service.LottoBuyService;
import base.backend.api.lotto.service.LottoDrawnService;
import base.backend.api.lotto.service.LottoRecommendService;
import base.backend.api.lotto.service.LottoSchedulerService;
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
    private final LottoBuyService lottoBuyService;
    private final LottoRecommendService lottoRecommendService;

    public LottoController(LottoSchedulerService lottoSchedulerService, LottoDrawnService lottoDrawnService, LottoBuyService lottoBuyService, LottoRecommendService lottoRecommendService) {

        this.lottoSchedulerService = lottoSchedulerService;
        this.lottoDrawnService = lottoDrawnService;
        this.lottoBuyService = lottoBuyService;
        this.lottoRecommendService = lottoRecommendService;
    }

    // 월요일 01:30에 실행 (cron = "초 분 시 일 월 요일")
    @Scheduled(cron = "* 30 1 * * 1") // 월요일 1시30분에 돈다
    public void getLottoDrawnNumbers() {

        try {
            System.out.println("매주 월요일 01:30 당첨번호 가져오기 실행 중... 현재 시간: " + LocalDateTime.now());
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
            System.err.println("스케줄 작업 중 오류 발생: " + e.getMessage());
            e.printStackTrace(); // 스택 트레이스 출력 추가
        }
    }

    // 데이터는 일요일 오전6시부터 토요일 오전6기준으로 잡고 문자가 가능하다면 문자로 오전7시에 데이터 전송
    @Scheduled(cron = "* * * * * *")
    public void buyLotto() {
        // System.out.println("로또 구매는 일요일 06:00 ~ 토요일 06:00.... 현재 시간 : " + LocalDateTime.currentDate());
        LocalDateTime currentDate = LocalDateTime.now();
        int currentDayValue = currentDate.getDayOfWeek().getValue();
        int currentHour = currentDate.getHour();

        // 크롤링해서 현재 동행복권의 회차를 가져오기
        int currentLottoDrwNo = lottoSchedulerService.getLottoDrawnNo();
        int buyLottoDrwNo = currentLottoDrwNo + 1;

        // 로또 데이터 저장 시장
        // 일요일 06:00 ~ 토요일 20:00 까지 구매 가능
        if ((currentDayValue >= 1 && currentDayValue <= 5) ||   // 월요일부터 금요일까지 전체
            (currentDayValue == 6 && currentHour <= 20) ||      // 토요일 20:00 이전
            (currentDayValue == 7 && currentHour >= 6)) {       // 일요일 06:00 이후
            lottoBuyService.insertBuyLottoData(currentDate, buyLottoDrwNo);
        } else {
            System.out.println("로또 구매 가능 시간 아님.");
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
