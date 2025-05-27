package project.backend.api.lotto.service.crud;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import project.backend.api.common.constants.LottoConstants;
import project.backend.api.lotto.sdo.LottoDrawnSdo;

@Slf4j
@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class LottoApiService {

    private final RestTemplate restTemplate = new RestTemplate();

    public LottoDrawnSdo getLottoDrawnNumbers(int targetDrawnNo) {

        try {
            String url = LottoConstants.LOTTO_API_URL + targetDrawnNo;
            // String으로 응답 받기
            String response = restTemplate.getForObject(url, String.class);

            // JSON 문자열을 LottoDrawnSdo 객체로 변환
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(response, LottoDrawnSdo.class);

        } catch (Exception e) {
            log.error("로또 API 클라이언트 에러 - 회차: {}, 에러: {}", targetDrawnNo, e.getMessage());
        }
        return null;
    }
}