package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;
import lotto.dto.LottoDto;
import lotto.dto.ResultDto;

import java.util.*;

public class Service {

    private PurchasePrice purchasePrice;
    private UserLotto userLotto;
    private WinningLotto winningLotto;
    private EnumMap<Result, Integer> results = new EnumMap<>(Result.class);

    public Service() {
        for (Result result : Result.values()) {
            results.put(result, 0);
        }
    }

    public void createPurchasePrice(int purchasePrice) {
        this.purchasePrice = new PurchasePrice(purchasePrice);
    }

    public void createUserLotto(int purchasePrice) {
        List<Lotto> userLotto = new ArrayList<>();
        for (int i = 0; i < purchasePrice / 1000; i++) {
            userLotto.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        this.userLotto = new UserLotto(userLotto);
    }

    public List<LottoDto> getUserLottoDto() {
        return userLotto.getUserLotto().stream()
                .map(lotto -> new LottoDto(lotto.getNumbers()))
                .toList();
    }

    public void createWinningLotto(List<Integer> winningLotto, int bonusNUmber) {
        this.winningLotto = new WinningLotto(winningLotto, bonusNUmber);
    }

    public void draw() {
        userLotto.draw(winningLotto).stream()
                .forEach(result -> results.put(result, results.get(result) + 1));
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
