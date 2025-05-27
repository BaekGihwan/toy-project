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

    public static LottoRecommend LottoRecommendSdo(LottoRecommendSdo sdo) {
        return LottoRecommend.builder()
            .recommendNo(sdo.getPurchaseNo())
            .recommendNo1(sdo.getPurchaseNo1())
            .recommendNo2(sdo.getPurchaseNo2())
            .recommendNo3(sdo.getPurchaseNo3())
            .recommendNo4(sdo.getPurchaseNo4())
            .recommendNo5(sdo.getPurchaseNo5())
            .recommendNo6(sdo.getPurchaseNo6())
            .recommendDate(sdo.getPurchaseDate())
            .build();
    }
}