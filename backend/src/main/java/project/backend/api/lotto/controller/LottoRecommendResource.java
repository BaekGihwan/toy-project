package project.backend.api.lotto.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.backend.api.lotto.sdo.LottoRecommendSdo;
import project.backend.api.lotto.service.flow.LottoRecommendFlowService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/recommend")
public class LottoRecommendResource {

    private final LottoRecommendFlowService lottoRecommendFlowService;

    @GetMapping
    public List<LottoRecommendSdo> getRecommendedLottoNumbers() {
        return lottoRecommendFlowService.getRecommendedLottoNumbers();
    }
}