package project.backend.api.lotto.store.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.backend.api.lotto.domain.LottoRecommend;
import project.backend.api.lotto.store.jpa.jpo.LottoRecommendJpo;
import project.backend.api.lotto.store.jpa.repository.LottoRecommendRepository;

import java.util.List;

@Transactional(readOnly = true)
@Repository
@RequiredArgsConstructor
public class LottoRecommendStore {

    private final LottoRecommendRepository lottoRecommendRepository;

    @Transactional
    public void registerLottoRecommendNumbers(LottoRecommend lottoRecommend) {
        lottoRecommendRepository.save(new LottoRecommendJpo(lottoRecommend));
    }
}
