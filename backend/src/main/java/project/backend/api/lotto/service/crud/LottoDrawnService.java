package project.backend.api.lotto.service.crud;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.backend.api.lotto.domain.LottoDrawn;
import project.backend.api.lotto.sdo.LottoDrawnSdo;
import project.backend.api.lotto.store.jpa.LottoDrawnStore;

import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class LottoDrawnService {

    private final LottoDrawnStore lottoDrawnStore;

    public LottoDrawn getLastDrawnNo() {
        return lottoDrawnStore.getLastDrawnNo();
    }

    public void registerLottoDrawnNumbers(LottoDrawnSdo lottoDrawnSdo) {
        lottoDrawnStore.save(lottoDrawnSdo);
    }

    public List<LottoDrawn> findAllByOrderByDrwNoDesc() {
        return lottoDrawnStore.findAllByOrderByDrwNoDesc();
    }
}
