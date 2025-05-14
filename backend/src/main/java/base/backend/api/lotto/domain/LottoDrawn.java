package base.backend.api.lotto.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "t_lotto_drawn")
public class LottoDrawn {

    @Id
    private int drw_no;
    private int drwt_no1;
    private int drwt_no2;
    private int drwt_no3;
    private int drwt_no4;
    private int drwt_no5;
    private int drwt_no6;
    private int bnus_no;
    private String drw_no_date;
}
