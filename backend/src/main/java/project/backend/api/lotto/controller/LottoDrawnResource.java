package project.backend.api.lotto.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;
import project.backend.api.lotto.service.flow.LottoDrawnNumbersFlowService;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class LottoDrawnResource {

    private final LottoDrawnNumbersFlowService lottoDrawnNumbersFlowService;

    @Scheduled(cron = "0 30 21 * * 6") // 매주 토요일 21:30
    public void getLottoDrawnNumbers() {
        System.out.println("매주 토요일 21:30 당첨번호 가져오기 실행 중... 현재 시간: " + LocalDateTime.now());
        lottoDrawnNumbersFlowService.getLottoDrawnNumbers();
    }
}
