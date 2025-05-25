package project.backend.api.lotto.service;


import project.backend.api.lotto.domain.LottoDrawn;
import project.backend.api.lotto.repository.LottoDrawnRepository;
import project.backend.api.lotto.sdo.LottoDrawnSdo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LottoDrawnService {

    private final LottoDrawnRepository lottoDrawnRepository;

    @Transactional(readOnly = true)
    public int getLastDrawnNo() {

        // drw_no가 가장 큰 한개만 가져와야댐
        LottoDrawn lastDrawn = lottoDrawnRepository.findTopByOrderByDrwNoDesc();
        return Integer.parseInt(lastDrawn != null ? String.valueOf(lastDrawn.getDrwNo()) : "");
    }

    @Transactional
    public void insertLottoWinningData(LottoDrawnSdo lottoDrawnSdo) {

        LottoDrawn lottoDraw = new LottoDrawn();
        // lottoDrawnSdo >  lottoDraw 엔티티로 변경
        lottoDraw.setDrwNo(lottoDrawnSdo.getDrwNo());
        lottoDraw.setDrwtNo1(lottoDrawnSdo.getDrwtNo1());
        lottoDraw.setDrwtNo2(lottoDrawnSdo.getDrwtNo2());
        lottoDraw.setDrwtNo3(lottoDrawnSdo.getDrwtNo3());
        lottoDraw.setDrwtNo4(lottoDrawnSdo.getDrwtNo4());
        lottoDraw.setDrwtNo5(lottoDrawnSdo.getDrwtNo5());
        lottoDraw.setDrwtNo6(lottoDrawnSdo.getDrwtNo6());
        lottoDraw.setBnusNo(lottoDrawnSdo.getBnusNo());
        lottoDraw.setDrwNoDate(lottoDrawnSdo.getDrwNoDate());

        // 하이버네이트 save사용
        lottoDrawnRepository.save(lottoDraw);
    }
}
