package project.backend.api.lotto.store.jpa.jpo;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import project.backend.api.lotto.domain.LottoDrawn;

@Entity
@Table(schema = "lotto")
@Comment("로또 당첨테이블")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class LottoDrawnJpo {  // Drawn: 이미 뽑힌, 추첨된 (과거분사/형용사)

    @Id
    @Column
    @Comment("당첨 회차")
    private int drwNo;

    @Column(nullable = false)
    @Comment("1번째 당첨번호")
    private int drwtNo1;

    @Column(nullable = false)
    @Comment("2번째 당첨번호")
    private int drwtNo2;

    @Column(nullable = false)
    @Comment("3번째 당첨번호")
    private int drwtNo3;

    @Column(nullable = false)
    @Comment("4번째 당첨번호")
    private int drwtNo4;

    @Column(nullable = false)
    @Comment("5번째 당첨번호")
    private int drwtNo5;

    @Column(nullable = false)
    @Comment("6번째 당첨번호")
    private int drwtNo6;

    @Column(nullable = false)
    @Comment("보너스 당첨번호")
    private int bnusNo;

    @Column(nullable = false)
    @Comment("추첨 날짜")
    private String drwNoDate;

    public LottoDrawnJpo(LottoDrawn lottoDrawn) {
        this.drwNo = lottoDrawn.getDrwNo();
        this.drwtNo1 = lottoDrawn.getDrwtNo1();
        this.drwtNo2 = lottoDrawn.getDrwtNo2();
        this.drwtNo3 = lottoDrawn.getDrwtNo3();
        this.drwtNo4 = lottoDrawn.getDrwtNo4();
        this.drwtNo5 = lottoDrawn.getDrwtNo5();
        this.drwtNo6 = lottoDrawn.getDrwtNo6();
        this.bnusNo = lottoDrawn.getBnusNo();
        this.drwNoDate = lottoDrawn.getDrwNoDate();
    }

    public LottoDrawn toDomain() {
        return LottoDrawn.builder()
            .drwNo(this.drwNo)
            .drwNoDate(this.drwNoDate)
            .drwtNo1(this.drwtNo1)
            .drwtNo2(this.drwtNo2)
            .drwtNo3(this.drwtNo3)
            .drwtNo4(this.drwtNo4)
            .drwtNo5(this.drwtNo5)
            .drwtNo6(this.drwtNo6)
            .bnusNo(this.bnusNo)
            .build();
    }
}