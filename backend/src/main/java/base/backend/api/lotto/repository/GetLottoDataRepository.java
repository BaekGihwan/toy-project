package base.backend.api.lotto.repository;


import base.backend.api.lotto.domain.LottoDrawn;
import base.backend.api.lotto.sdo.LottoDrawnSdo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Repository
@RequiredArgsConstructor
public class GetLottoDataRepository {

    private final RestTemplate restTemplate;
    private final String LOTTO_API_URL = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=";


    public LottoDrawnSdo getWinningNumbers() {
        try {
            String url = LOTTO_API_URL + 1;
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

    public GetLottoDataRepository() {
        this.restTemplate = new RestTemplate();

        // MappingJackson2HttpMessageConverter 설정 추가
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        // text/html 미디어 타입도 처리할 수 있도록 설정
        converter.setSupportedMediaTypes(
                Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML)
        );
        restTemplate.getMessageConverters().add(converter);
    }

}




