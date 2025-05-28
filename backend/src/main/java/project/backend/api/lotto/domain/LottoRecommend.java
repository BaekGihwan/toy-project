package project.backend.api.lotto.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.api.lotto.sdo.LottoRecommendSdo;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class LottoRecommend {

    private int recommendId;
    private int recommendNo;
    private int recommendNo1;
    private int recommendNo2;
    private int recommendNo3;
    private int recommendNo4;
    private int recommendNo5;
    private int recommendNo6;
    private LocalDateTime recommendDate;

    // Sdo -> domain
    public static LottoRecommend LottoRecommendSdo(LottoRecommendSdo lottoRecommendSdo) {
        return LottoRecommend.builder()
            .recommendNo(lottoRecommendSdo.getPurchaseNo())
            .recommendNo1(lottoRecommendSdo.getPurchaseNo1())
            .recommendNo2(lottoRecommendSdo.getPurchaseNo2())
            .recommendNo3(lottoRecommendSdo.getPurchaseNo3())
            .recommendNo4(lottoRecommendSdo.getPurchaseNo4())
            .recommendNo5(lottoRecommendSdo.getPurchaseNo5())
            .recommendNo6(lottoRecommendSdo.getPurchaseNo6())
            .recommendDate(lottoRecommendSdo.getPurchaseDate())
            .build();
    }
}