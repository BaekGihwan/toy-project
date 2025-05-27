package project.backend.api.lotto.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;
import project.backend.api.lotto.service.flow.LottoPurchaseFlowService;

@RestController
@RequiredArgsConstructor
public class LottoPurchaseResource {

    private final LottoPurchaseFlowService lottoPurchaseFlowService;

//    @Scheduled(fixedDelay = 100) // 0.1초마다
    public void getLottoDrawnNumbers() {
        lottoPurchaseFlowService.registerPurchaseLotto();
    }
}
