package project.backend.api.lotto.domain;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class LottoPurchase {

    private int purchaseId;
    private int purchaseNo;
    private int purchaseNo1;
    private int purchaseNo2;
    private int purchaseNo3;
    private int purchaseNo4;
    private int purchaseNo5;
    private int purchaseNo6;
    private LocalDateTime purchaseDate;
}