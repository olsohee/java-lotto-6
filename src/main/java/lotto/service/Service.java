package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;
import lotto.dto.LottoDto;
import lotto.dto.ResultDto;

import java.util.*;

public class Service {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private PurchasePrice purchasePrice;
    private UserLotto userLotto;
    private WinningLotto winningLotto;
    private EnumMap<Result, Integer> results = new EnumMap<>(Result.class);

    public Service() {
        for (Result result : Result.values()) {
            results.put(result, 0);
        }
    }

    public void buyUserLotto(int purchasePrice) {
        this.purchasePrice = new PurchasePrice(purchasePrice);

        List<Lotto> userLotto = new ArrayList<>();
        while (userLotto.size() < purchasePrice / LottoCondition.LOTTO_PRICE.getValue()) {
            userLotto.add(new Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT)));
        }
        this.userLotto = new UserLotto(userLotto);
    }

    public void generateWinningLotto(List<Integer> winningLotto, int bonusNUmber) {
        this.winningLotto = new WinningLotto(winningLotto, bonusNUmber);
    }

    public void draw() {
        userLotto.draw(winningLotto).stream()
                .forEach(result -> results.put(result, results.get(result) + 1));
    }

    public List<LottoDto> getUserLottoDto() {
        return userLotto.getUserLotto().stream()
                .map(lotto -> new LottoDto(lotto.getNumbers()))
                .toList();
    }

    public ResultDto getResultDto() {
        results.remove(Result.FAIL);
        return new ResultDto(results, calculateReturnRate(results));
    }

    private double calculateReturnRate(EnumMap<Result, Integer> resultMap) {
        int totalProfitAmount = 0;
        for (Result key : resultMap.keySet()) {
            totalProfitAmount += resultMap.get(key) * key.getProfitAmount();
        }
        return (((double) totalProfitAmount) / purchasePrice.getPurchasePrice()) * 100;
    }
}
