package project.backend.api.lotto.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.backend.api.lotto.sdo.LottoRecommendSdo;
import project.backend.api.lotto.service.flow.LottoRecommendFlowService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lotto/api/v1/")
public class LottoRecommendResource {

    private final LottoRecommendFlowService lottoRecommendFlowService;

    @GetMapping("recommend")
    public List<LottoRecommendSdo> getRecommendedLottoNumbers() {
        return lottoRecommendFlowService.getRecommendedLottoNumbers();
    }
}