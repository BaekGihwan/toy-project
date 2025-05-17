package base.backend.api.lotto.repository;


import base.backend.api.lotto.domain.LottoDrawn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LottoDrawnRepository extends JpaRepository<LottoDrawn, Integer> {

    // 가장 최근 추첨 번호 조회
    LottoDrawn findTopByOrderByDrwNoDesc();
}