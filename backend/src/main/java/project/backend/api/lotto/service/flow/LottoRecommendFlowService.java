package project.backend.api.lotto.service.flow;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.backend.api.lotto.domain.LottoDrawn;
import project.backend.api.lotto.domain.LottoPurchase;
import project.backend.api.lotto.domain.LottoRecommend;
import project.backend.api.lotto.sdo.LottoDrawnSdo;
import project.backend.api.lotto.sdo.LottoRecommendSdo;
import project.backend.api.lotto.service.crud.LottoDrawnService;
import project.backend.api.lotto.service.crud.LottoPurchaseService;
import project.backend.api.lotto.service.crud.LottoRecommendService;

import java.time.LocalDateTime;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class LottoRecommendFlowService {

    private final LottoDrawnService lottoDrawnService;
    private final LottoPurchaseService lottoPurchaseService;
    private final LottoRecommendService lottoRecommendService;

    @Transactional
    public List<LottoRecommendSdo> getRecommendedLottoNumbers() {

        // 1. 역대 당첨번호 가져오기 && 데이터 가공
        List<LottoDrawn> drawnResultList = lottoDrawnService.findAllByOrderByDrwNoDesc();
        // 2. 6자리를 조합하여 drawnCombinedNumber에 넣기
        List<LottoDrawnSdo> drawnResultListAddCombinedNumber = drawnResultList.stream()
            .map(drawnList -> {
                String combinedNumber = String.format("%d-%d-%d-%d-%d-%d",
                    drawnList.getDrwtNo1(),
                    drawnList.getDrwtNo2(),
                    drawnList.getDrwtNo3(),
                    drawnList.getDrwtNo4(),
                    drawnList.getDrwtNo5(),
                    drawnList.getDrwtNo6());
                return LottoDrawnSdo.builder()
                    .drwNo(drawnList.getDrwNo())
                    .drwtNo1(drawnList.getDrwtNo1())
                    .drwtNo2(drawnList.getDrwtNo2())
                    .drwtNo3(drawnList.getDrwtNo3())
                    .drwtNo4(drawnList.getDrwtNo4())
                    .drwtNo5(drawnList.getDrwtNo5())
                    .drwtNo6(drawnList.getDrwtNo6())
                    .drawnCombinedNumber(combinedNumber)
                    .build();
            })
            .sorted(Comparator.comparing(LottoDrawnSdo::getDrwNo).reversed()) // 기본이 ASC / reversed DESC
            .toList();

        // 3. 추천회차 구매내역 가져오기
        List<LottoPurchase> purchaseResultList = lottoPurchaseService.findAllByPurchaseNoOrderByPurchaseIdDesc(drawnResultListAddCombinedNumber.get(0).getDrwNo() + 1);
        // 4. 6자리를 조합하여 purchaseCombinedNumber에 넣기
        List<LottoRecommendSdo> purchaseResultListAddCombinedNumberAndCount = purchaseResultList.stream()
            .collect(Collectors.groupingBy(
                purchaseList -> new AbstractMap.SimpleEntry<>(
                    new AbstractMap.SimpleEntry<>(
                        String.format("%d-%d-%d-%d-%d-%d",
                            purchaseList.getPurchaseNo1(),
                            purchaseList.getPurchaseNo2(),
                            purchaseList.getPurchaseNo3(),
                            purchaseList.getPurchaseNo4(),
                            purchaseList.getPurchaseNo5(),
                            purchaseList.getPurchaseNo6()),
                        purchaseList.getPurchaseDate()  // 날짜 정보 저장
                    ),
                    purchaseList.getPurchaseNo()    // 회차 정보 추가
                ),
                Collectors.counting()
            ))
            .entrySet().stream()
            .map(entry -> {
                String combinedNumber = entry.getKey().getKey().getKey(); // 번호 조합
                LocalDateTime purchaseDateTime = (LocalDateTime) entry.getKey().getKey().getValue();
                Integer purchaseNo = entry.getKey().getValue(); // 회차 정보 추출
                String[] numbers = combinedNumber.split("-");

                return LottoRecommendSdo.builder()
                    .purchaseNo1(Integer.parseInt(numbers[0]))
                    .purchaseNo2(Integer.parseInt(numbers[1]))
                    .purchaseNo3(Integer.parseInt(numbers[2]))
                    .purchaseNo4(Integer.parseInt(numbers[3]))
                    .purchaseNo5(Integer.parseInt(numbers[4]))
                    .purchaseNo6(Integer.parseInt(numbers[5]))
                    .purchaseCombinedNumber(combinedNumber)
                    .duplicateCount(entry.getValue().intValue())
                    .purchaseDate(purchaseDateTime) // 날짜 정보 설정
                    .purchaseNo(purchaseNo) // 회차 정보 설정
                    .build();
            })
            .sorted(Comparator.comparing(LottoRecommendSdo::getDuplicateCount).thenComparing(LottoRecommendSdo::getPurchaseDate).reversed()) // 정렬 기준 수정
            .toList();

        List<LottoRecommendSdo> LottoRecommendList = purchaseResultListAddCombinedNumberAndCount.stream()
            // drawnResultListAddCombinedNumber에 포함되지 않은 항목만 필터링
            .filter(item -> !drawnResultListAddCombinedNumber.contains(item.getPurchaseCombinedNumber()))
            .sorted(Comparator.comparing(LottoRecommendSdo::getDuplicateCount).thenComparing(LottoRecommendSdo::getPurchaseNo))
            .limit(5)
            .toList();

        // 데이터 저장 - SDO를 도메인 엔티티로 변환하여 저장
        LottoRecommendList.stream()
            .map(LottoRecommend::LottoRecommendSdo)
            .forEach(lottoRecommendService::registerLottoRecommendNumbers);

        return LottoRecommendList;
    }
}
