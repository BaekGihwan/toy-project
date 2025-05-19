package base.backend.api.lotto.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "t_lotto_recommend")
public class LottoRecommend {
    // ID가 필요가 없는데... 흐음 있어야 할까
    @Id
    private UUID virtualId = UUID.randomUUID();

    @Column(name = "recommend_no")
    private int recommendNo;

    @Column(name = "recommend_no1")
    private int recommendNo1;

    @Column(name = "recommend_no2")
    private int recommendNo2;

    @Column(name = "recommend_no3")
    private int recommendNo3;

    @Column(name = "recommend_no4")
    private int recommendNo4;

    @Column(name = "recommend_no5")
    private int recommendNo5;

    @Column(name = "recommend_no6")
    private int recommendNo6;

    @Column(name = "recommend_bonus_no")
    private int recommendBonusNo;

    @Column(name = "recommend_date")
    private LocalDateTime recommendDate;

    @Override
    public String toString() {
        return String.format(
                "로또 %d회차 (%s) - 추천번호: %d, %d, %d, %d, %d, %d, 보너스: %d",
                recommendNo, recommendDate, recommendNo1, recommendNo2, recommendNo3, recommendNo4, recommendNo5, recommendNo6, recommendBonusNo
        );
    }
}