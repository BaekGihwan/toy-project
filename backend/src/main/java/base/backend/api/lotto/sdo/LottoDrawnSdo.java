package base.backend.api.lotto.sdo;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LottoDrawnSdo {

    @JsonProperty
    private String returnValue;
    @JsonProperty
    private int drwNo;           // 회차
    @JsonProperty
    private String drwNoDate;    // 추첨일
    @JsonProperty
    private int drwtNo1;         // 당첨번호 1
    @JsonProperty
    private int drwtNo2;         // 당첨번호 2
    @JsonProperty
    private int drwtNo3;         // 당첨번호 3
    @JsonProperty
    private int drwtNo4;         // 당첨번호 4
    @JsonProperty
    private int drwtNo5;         // 당첨번호 5
    @JsonProperty
    private int drwtNo6;         // 당첨번호 6
    @JsonProperty
    private int bnusNo;          // 보너스 번호
    @JsonProperty
    private long firstWinamnt;   // 1등 당첨금
    @JsonProperty
    private int firstPrzwnerCo;  // 1등 당첨자 수
    @JsonProperty
    private long firstAccumamnt;
    @JsonProperty
    private long totSellamnt;    // 총 판매금액
    private String drawnCombinedNumber;

    @Override
    public String toString() {
        return String.format(
                "로또 %d회차 (%s) - 당첨번호: %d, %d, %d, %d, %d, %d, 보너스: %d",
                drwNo, drwNoDate, drwtNo1, drwtNo2, drwtNo3, drwtNo4, drwtNo5, drwtNo6, bnusNo
        );
    }
}








