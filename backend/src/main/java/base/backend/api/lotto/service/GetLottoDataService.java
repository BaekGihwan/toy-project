package base.backend.api.lotto.service;


import base.backend.api.lotto.repository.GetLottoDataRepository;
import base.backend.api.lotto.sdo.LottoDrawnSdo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetLottoDataService {

    private final GetLottoDataRepository getLottoDataRepository;

    LottoDrawnSdo lottoDrawnSdo = new LottoDrawnSdo();

    public LottoDrawnSdo getWinningNumbers() {

        try {

            lottoDrawnSdo = getLottoDataRepository.getWinningNumbers();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return lottoDrawnSdo;
    }
}
