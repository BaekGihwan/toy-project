package base.backend.api.lotto.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "t_lotto_purchase")
public class LottoPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private int purchaseId;

    @Column(name = "purchase_no")
    private int purchaseNo;

    @Column(name = "purchase_no1")
    private int purchaseNo1;

    @Column(name = "purchase_no2")
    private int purchaseNo2;

    @Column(name = "purchase_no3")
    private int purchaseNo3;

    @Column(name = "purchase_no4")
    private int purchaseNo4;

    @Column(name = "purchase_no5")
    private int purchaseNo5;

    @Column(name = "purchase_no6")
    private int purchaseNo6;

    @Column(name = "purchase_date")
    private LocalDateTime purchaseDate;

    @Override
    public String toString() {
        return String.format(
                "로또 %d회차 (%s) - 구매번호: %d, %d, %d, %d, %d, %d",
                purchaseNo, purchaseDate, purchaseNo1, purchaseNo2, purchaseNo3, purchaseNo4, purchaseNo5, purchaseNo6
        );
    }
}