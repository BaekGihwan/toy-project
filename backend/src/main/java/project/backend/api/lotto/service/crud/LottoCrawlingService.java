package project.backend.api.lotto.service.crud;


import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.backend.api.common.constants.LottoConstants;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class LottoCrawlingService {

    public int getLottoDrawnNo() {

        try {
            // Jsoup을 사용하여 웹페이지 내용 가져오기
            Document doc = Jsoup.connect(LottoConstants.LOTTO_URL).get();
            // id가 "lottoDrwNo"인 요소 찾기
            Element element = doc.getElementById("lottoDrwNo");

            if (element != null) {
                return Integer.parseInt(element.text());
            } else {
                throw new RuntimeException("로또 회차 정보를 찾을 수 없음");
            }
        } catch (Exception e) {
            throw new RuntimeException("로또 웹페이지 접속 불가: " + e.getMessage());
        }
    }
}
