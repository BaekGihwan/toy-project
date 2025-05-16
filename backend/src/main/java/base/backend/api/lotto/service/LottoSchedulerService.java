package base.backend.api.lotto.service;


import base.backend.api.lotto.repository.LottoSchedulerRepository;
import base.backend.api.lotto.sdo.LottoDrawnSdo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LottoSchedulerService {

    private final LottoSchedulerRepository lottoSchedulerRepository;

    LottoDrawnSdo lottoDrawnSdo = new LottoDrawnSdo();

    // 동행복권 크롤링하여 현재 회차 가져오기
    public int getLottoDrawnNo() {

        return lottoSchedulerRepository.getLottoDrawnNo();
    }

    // 동해복권 api를 통해서 1등 당첨번호 가져오기
    public LottoDrawnSdo getWinningNumbers(int lottoDrawnNo) {

        try {
            lottoDrawnSdo = lottoSchedulerRepository.getWinningNumbers(lottoDrawnNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lottoDrawnSdo;
    }
}
