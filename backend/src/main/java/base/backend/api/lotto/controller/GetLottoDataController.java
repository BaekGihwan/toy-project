package base.backend.api.lotto.controller;


import base.backend.api.lotto.sdo.LottoDrawnSdo;
import base.backend.api.lotto.service.GetLottoDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetLottoDataController {

    private final GetLottoDataService getLottoDataService;

    @GetMapping("/getWinningNumbers")
    public void getWinningNumbers() {

        // 페이지에서 데이터 가져오기
        LottoDrawnSdo lottoDrawnSdo = getLottoDataService.getWinningNumbers();

        // 로또 가지고 디비에 저장
//        getLottoDataService.insertWinningNumbers();

    }
}
