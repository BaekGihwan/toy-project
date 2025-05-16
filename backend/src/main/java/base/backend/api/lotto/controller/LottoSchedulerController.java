package base.backend.api.lotto.controller;


import base.backend.api.lotto.sdo.LottoDrawnSdo;
import base.backend.api.lotto.service.LottoDataService;
import base.backend.api.lotto.service.LottoSchedulerService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LottoSchedulerController {

    private final LottoSchedulerService lottoSchedulerService;
    private final LottoDataService lottoDataService;

    public LottoSchedulerController(LottoSchedulerService lottoSchedulerService, LottoDataService lottoDataService) {

        this.lottoSchedulerService = lottoSchedulerService;
        this.lottoDataService = lottoDataService;
    }

    // 매일 01:00에 실행 (cron = "초 분 시 일 월 요일")
    @Scheduled(cron = "0/30 * * * * *") // 30초마다 실행
    public void getLottoDrawnNumbers() {

        try {
            System.out.println("매일 01:30 작업 실행 중... 현재 시간: " + LocalDateTime.now());
            int currentLottoDrwNo;
            int lastSavedDrwNo;
            int getDrwNo;

            // 크롤링해서 현재 동행복권의 회차를 가져오기
            currentLottoDrwNo = lottoSchedulerService.getLottoDrawnNo();

            // 현재 디비에 저장 되어있는 마지막회차 가져오기
            lastSavedDrwNo = lottoDataService.getLastDrawnNo();

            // 디비의 마지막회차가 현재 회차보다 낮으면 디비회차 +1 가져오고
            if(currentLottoDrwNo > lastSavedDrwNo) {
                getDrwNo = lastSavedDrwNo + 1;
                // api를통해서 당첨번호 가져오기
                LottoDrawnSdo lottoDrawnSdo = lottoSchedulerService.getWinningNumbers(getDrwNo);
                // db에 insert 진행
                lottoDataService.insertLottoDrawnData(lottoDrawnSdo);

            }

        } catch (Exception e) {
            // 예외 로깅 및 처리
            System.err.println("스케줄 작업 중 오류 발생: " + e.getMessage());
            e.printStackTrace(); // 스택 트레이스 출력 추가
        }
    }
}