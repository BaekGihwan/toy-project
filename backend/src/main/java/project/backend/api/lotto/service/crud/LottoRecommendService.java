package project.backend.api.lotto.service.crud;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.backend.api.lotto.domain.LottoRecommend;
import project.backend.api.lotto.store.jpa.LottoRecommendStore;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class LottoRecommendService {

    private final LottoRecommendStore lottoRecommendStore;

    public void registerLottoRecommendNumbers(LottoRecommend lottoRecommend) {
        lottoRecommendStore.save(lottoRecommend);
    }
}