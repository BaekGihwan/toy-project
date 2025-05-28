package project.backend.api.lotto.store.jpa.jpo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import project.backend.api.lotto.domain.LottoPurchase;

import java.time.LocalDateTime;

@Entity
@Table(schema = "lotto")
@Comment("로또 구매테이블")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class LottoPurchaseJpo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int purchaseId;

    @Column(nullable = false)
    @Comment("구매 회차")
    private int purchaseNo;

    @Column(nullable = false)
    @Comment("1번째 구매번호")
    private int purchaseNo1;

    @Column(nullable = false)
    @Comment("2번째 구매번호")
    private int purchaseNo2;

    @Column(nullable = false)
    @Comment("3번째 구매번호")
    private int purchaseNo3;

    @Column(nullable = false)
    @Comment("4번째 구매번호")
    private int purchaseNo4;

    @Column(nullable = false)
    @Comment("5번째 구매번호")
    private int purchaseNo5;

    @Column(nullable = false)
    @Comment("6번째 구매번호")
    private int purchaseNo6;

    @Column(nullable = false)
    @Comment("구매 날짜")
    private LocalDateTime purchaseDate;

    public LottoPurchaseJpo(LottoPurchase lottoPurchase) {
        this.purchaseId = lottoPurchase.getPurchaseId();
        this.purchaseNo = lottoPurchase.getPurchaseNo();
        this.purchaseNo1 = lottoPurchase.getPurchaseNo1();
        this.purchaseNo2 = lottoPurchase.getPurchaseNo2();
        this.purchaseNo3 = lottoPurchase.getPurchaseNo3();
        this.purchaseNo4 = lottoPurchase.getPurchaseNo4();
        this.purchaseNo5 = lottoPurchase.getPurchaseNo5();
        this.purchaseNo6 = lottoPurchase.getPurchaseNo6();
        this.purchaseDate = lottoPurchase.getPurchaseDate();
    }

    public LottoPurchase toDomain() {
        return LottoPurchase.builder()
            .purchaseId(this.purchaseId)
            .purchaseNo(this.purchaseNo)
            .purchaseNo1(this.purchaseNo1)
            .purchaseNo2(this.purchaseNo2)
            .purchaseNo3(this.purchaseNo3)
            .purchaseNo4(this.purchaseNo4)
            .purchaseNo5(this.purchaseNo5)
            .purchaseNo6(this.purchaseNo6)
            .purchaseDate(this.purchaseDate)
            .build();
    }
}