package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.PurchasePrice;
import lotto.domain.UserLotto;

import java.util.ArrayList;
import java.util.List;

public class Service {

    private PurchasePrice purchasePrice;
    private UserLotto userLotto;

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
}
