package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.PurchasePrice;

public class Service {

    private PurchasePrice purchasePrice;
    private Lotto winningLotto;

    public void createPurchasePrice(int purchasePrice) {
        this.purchasePrice = new PurchasePrice(purchasePrice);
    }

    public void createWinningLotto() {
        winningLotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
