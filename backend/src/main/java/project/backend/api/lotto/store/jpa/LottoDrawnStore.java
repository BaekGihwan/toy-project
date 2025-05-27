package project.backend.api.lotto.store.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.backend.api.lotto.domain.LottoDrawn;
import project.backend.api.lotto.sdo.LottoDrawnSdo;
import project.backend.api.lotto.store.jpa.jpo.LottoDrawnJpo;
import project.backend.api.lotto.store.jpa.repository.LottoDrawnRepository;

import java.util.List;

@Transactional(readOnly = true)
@Repository
@RequiredArgsConstructor
public class LottoDrawnStore {

    private final LottoDrawnRepository lottoDrawnRepository;

    public LottoDrawn getLastDrawnNo() {
        return lottoDrawnRepository.findTopByOrderByDrwNoDesc()
            .map(LottoDrawnJpo::toDomain)
            .orElse(null);
    }

    @Transactional
    public void save(LottoDrawnSdo lottoDrawnSdo) {
        // SDO -> 도메인 -> JPO 변환 후 저장
        LottoDrawn lottoDrawn = LottoDrawn.lottoDrawnSdo(lottoDrawnSdo);
        lottoDrawnRepository.save(new LottoDrawnJpo(lottoDrawn));
    }

    public List<LottoDrawn> findAllByOrderByDrwNoDesc() {
        return lottoDrawnRepository.findAllByOrderByDrwNoDesc().stream()
            .map(LottoDrawnJpo::toDomain)
            .toList();
    }
}
