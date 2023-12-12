package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.PurchasePrice;
import lotto.domain.UserLotto;
import lotto.domain.WinningLotto;
import lotto.dto.LottoDto;

import java.util.ArrayList;
import java.util.List;

public class Service {

    private PurchasePrice purchasePrice;
    private UserLotto userLotto;
    private WinningLotto winningLotto;

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

    }
}
