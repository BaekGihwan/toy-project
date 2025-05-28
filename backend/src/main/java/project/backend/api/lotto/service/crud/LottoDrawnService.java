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
        lottoDrawnStore.registerLottoDrawnNumbers(lottoDrawnSdo);
    }

    public List<LottoDrawn> getDrawnNumbersList() {
        return lottoDrawnStore.getDrawnNumbersList();
    }
}
