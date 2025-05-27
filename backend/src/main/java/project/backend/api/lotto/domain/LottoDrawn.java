package project.backend.api.lotto.domain;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.backend.api.lotto.sdo.LottoDrawnSdo;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class LottoDrawn {  // Drawn: 이미 뽑힌, 추첨된 (과거분사/형용사)

    private int drwNo;
    private int drwtNo1;
    private int drwtNo2;
    private int drwtNo3;
    private int drwtNo4;
    private int drwtNo5;
    private int drwtNo6;
    private int bnusNo;
    private String drwNoDate;

    // Sdo -> domain
    public static LottoDrawn lottoDrawnSdo(LottoDrawnSdo lottoDrawnSdo) {
        return LottoDrawn.builder()
            .drwNo(lottoDrawnSdo.getDrwNo())
            .drwNoDate(lottoDrawnSdo.getDrwNoDate())
            .drwtNo1(lottoDrawnSdo.getDrwtNo1())
            .drwtNo2(lottoDrawnSdo.getDrwtNo2())
            .drwtNo3(lottoDrawnSdo.getDrwtNo3())
            .drwtNo4(lottoDrawnSdo.getDrwtNo4())
            .drwtNo5(lottoDrawnSdo.getDrwtNo5())
            .drwtNo6(lottoDrawnSdo.getDrwtNo6())
            .bnusNo(lottoDrawnSdo.getBnusNo())
            .build();
    }
}