package base.backend.api.common.constants;

public final class LottoConstants {
    // 로또 데이터 관련 상수 데이터
    public static final String LOTTO_API_URL = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=";
    public static final String LOTTO_URL = "https://dhlottery.co.kr/common.do?method=main";
    public static final int MAX_LOTTO_NUMBER = 45;

    private LottoConstants() {} // 인스턴스화 방지
}
