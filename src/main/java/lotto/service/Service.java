package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;
import lotto.dto.LottoDto;
import lotto.dto.ResultDto;

import java.util.*;

import static lotto.domain.LottoCondition.*;

public class Service {
    private PurchasePrice purchasePrice;
    private UserLotto userLotto;
    private WinningLotto winningLotto;
    private WinningResult winningResult;

    public void buyUserLotto(int purchasePrice) {
        this.purchasePrice = new PurchasePrice(purchasePrice);

        List<Lotto> userLotto = new ArrayList<>();
        while (userLotto.size() < purchasePrice / LottoCondition.LOTTO_PRICE.getValue()) {
            userLotto.add(new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER.getValue(), MAX_NUMBER.getValue(), LOTTO_NUMBER_COUNT.getValue())));
        }
        this.userLotto = new UserLotto(userLotto);
    }

    public void generateWinningLotto(List<Integer> winningLotto, int bonusNUmber) {
        this.winningLotto = new WinningLotto(winningLotto, bonusNUmber);
    }

    public void generateWinningResult() {
        this.winningResult = new WinningResult(userLotto, winningLotto, purchasePrice);
    }

    public List<LottoDto> getUserLottoDto() {
        return userLotto.getUserLotto().stream()
                .map(lotto -> new LottoDto(lotto.getNumbers()))
                .toList();
    }

    public ResultDto getResultDto() {
        return new ResultDto(winningResult.getRankings(), winningResult.getReturnRate());
    }
}
