package project.backend.api.lotto.domain;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "t_lotto_drawn")
public class LottoDrawn {

    @Id
    @Column(name = "drw_no")
    private int drwNo;

    @Column(name = "drwt_no1")
    private int drwtNo1;

    @Column(name = "drwt_no2")
    private int drwtNo2;

    @Column(name = "drwt_no3")
    private int drwtNo3;

    @Column(name = "drwt_no4")
    private int drwtNo4;

    @Column(name = "drwt_no5")
    private int drwtNo5;

    @Column(name = "drwt_no6")
    private int drwtNo6;

    @Column(name = "bnus_no")
    private int bnusNo;

    @Column(name = "drw_no_date")
    private String drwNoDate;

    @Override
    public String toString() {
        return String.format(
                "로또 %d회차 (%s) - 당첨번호: %d, %d, %d, %d, %d, %d, 보너스: %d",
                drwNo, drwNoDate, drwtNo1, drwtNo2, drwtNo3, drwtNo4, drwtNo5, drwtNo6, bnusNo
        );
    }
}