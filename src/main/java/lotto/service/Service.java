package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;
import lotto.dto.LottoDto;
import lotto.dto.ResultDto;

import java.util.*;

import static lotto.constant.LottoCondition.*;

public class Service {
    private PurchasePrice purchasePrice;
    private Lottos userLottos = new Lottos();
    private Lotto winningLotto;
    private BonusNumber bonusNumber;
    private WinningResult winningResult;

    public void buyUserLotto(int purchasePrice) {
        this.purchasePrice = new PurchasePrice(purchasePrice);

        int count = purchasePrice / LOTTO_PRICE.getValue();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER.getValue(), MAX_NUMBER.getValue(), LOTTO_NUMBER_COUNT.getValue()));
            userLottos.addLotto(lotto);
        }
    }

    public void generateWinningLotto(List<Integer> winningLotto, int bonusNumber) {
        this.winningLotto = new Lotto(winningLotto);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    public void generateWinningResult() {
        this.winningResult = new WinningResult(userLottos, winningLotto, bonusNumber, purchasePrice);
    }

    public List<LottoDto> getUserLottoDto() {
        return userLottos.getLottos().stream()
                .map(lotto -> new LottoDto(lotto.getNumbers()))
                .toList();
    }

    public ResultDto getResultDto() {
        return new ResultDto(winningResult.getRankings(), winningResult.getReturnRate());
    }
}
