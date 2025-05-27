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
import project.backend.api.lotto.domain.LottoRecommend;

import java.time.LocalDateTime;

@Entity
@Table(schema = "lotto")
@Comment("로또 추천테이블")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class LottoRecommendJpo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int recommendId;

    @Column(nullable = false)
    @Comment("추천 회차")
    private int recommendNo;

    @Column(nullable = false)
    @Comment("1번째 추천번호")
    private int recommendNo1;

    @Column(nullable = false)
    @Comment("2번째 추천번호")
    private int recommendNo2;

    @Column(nullable = false)
    @Comment("3번째 추천번호")
    private int recommendNo3;

    @Column(nullable = false)
    @Comment("4번째 추천번호")
    private int recommendNo4;

    @Column(nullable = false)
    @Comment("5번째 추천번호")
    private int recommendNo5;

    @Column(nullable = false)
    @Comment("6번째 추천번호")
    private int recommendNo6;

    @Column(nullable = false)
    @Comment("추천 날짜")
    private LocalDateTime recommendDate;

    public LottoRecommendJpo(LottoRecommend lottoRecommend) {
        this.recommendNo = lottoRecommend.getRecommendNo();
        this.recommendNo1 = lottoRecommend.getRecommendNo1();
        this.recommendNo2 = lottoRecommend.getRecommendNo2();
        this.recommendNo3 = lottoRecommend.getRecommendNo3();
        this.recommendNo4 = lottoRecommend.getRecommendNo4();
        this.recommendNo5 = lottoRecommend.getRecommendNo5();
        this.recommendNo6 = lottoRecommend.getRecommendNo6();
        this.recommendDate = lottoRecommend.getRecommendDate();
    }

    public LottoRecommend toDomain() {
        return LottoRecommend.builder()
            .recommendId(this.recommendId)
            .recommendNo(this.recommendNo)
            .recommendNo1(this.recommendNo1)
            .recommendNo2(this.recommendNo2)
            .recommendNo3(this.recommendNo3)
            .recommendNo4(this.recommendNo4)
            .recommendNo5(this.recommendNo5)
            .recommendNo6(this.recommendNo6)
            .recommendDate(this.recommendDate)
            .build();
    }
}