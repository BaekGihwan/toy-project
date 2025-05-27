package project.backend.api.lotto.sdo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LottoRecommendSdo {

    private int purchaseNo;
    private int purchaseNo1;
    private int purchaseNo2;
    private int purchaseNo3;
    private int purchaseNo4;
    private int purchaseNo5;
    private int purchaseNo6;
    private LocalDateTime purchaseDate;
    private String purchaseCombinedNumber;
    private int duplicateCount;
}
