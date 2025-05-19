package base.backend.api.lotto.sdo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class LottoRecommendSdo {

    private int purchaseNo;     // 추천회차
    private int purchaseNo1;    // 추천번호 1
    private int purchaseNo2;    // 추천번호 2
    private int purchaseNo3;    // 추천번호 3
    private int purchaseNo4;    // 추천번호 4
    private int purchaseNo5;    // 추천번호 5
    private int purchaseNo6;    // 추천번호 6
    private String purchaseCombinedNumber; // 추천번호 결함된 데이터
    private int duplicateCount;          // 중복 카운트
    private LocalDateTime purchaseDate;
}
