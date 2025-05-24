package base.backend.api.lotto.repository;


import base.backend.api.common.constants.LottoConstants;
import base.backend.api.lotto.sdo.LottoDrawnSdo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;

@Repository
@RequiredArgsConstructor
public class LottoSchedulerRepository {

    private final RestTemplate restTemplate = new RestTemplate();

    public int getLottoDrawnNo() {

        try {
            // Jsoup을 사용하여 웹페이지 내용 가져오기
            Document doc = Jsoup.connect(LottoConstants.LOTTO_URL).get();

            // id가 "lottoDrwNo"인 요소 찾기
            Element element = doc.getElementById("lottoDrwNo");

            if (element != null) {
                return Integer.parseInt(element.text()); // 요소의 텍스트 값(회차 번호) Integer로 변경
            } else {
                throw new RuntimeException("로또 회차 정보를 찾을 수 없습니다.");
            }
        } catch (IOException e) {
            throw new RuntimeException("로또 웹페이지 접속 불가: " + e.getMessage());
        }
    }

    public LottoDrawnSdo getWinningNumbers(int lottoDrawnNo) {

        try {
            String url = LottoConstants.LOTTO_API_URL + lottoDrawnNo;
            // String으로 응답 받기
            String response = restTemplate.getForObject(url, String.class);

            // JSON 문자열을 LottoDrawnSdo 객체로 변환
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(response, LottoDrawnSdo.class);

        } catch (Exception e) {
            e.printStackTrace();
            return new LottoDrawnSdo(); // 오류 시 빈 객체 반환
        }
    }

    public void LottoSchedulerRepository() {
        // 생성자
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(
                Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML)
        );
        restTemplate.getMessageConverters().add(converter);
    }
}
