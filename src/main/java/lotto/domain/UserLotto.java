package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class UserLotto {

    private final List<Lotto> lottos = new ArrayList<>();
    private final int purchasePrice;
    private final int lottoCount;

    public UserLotto(int purchasePrice) {
        validate(purchasePrice);
        this.purchasePrice = purchasePrice;
        this.lottoCount = purchasePrice / 1000;
        generateLottos(lottoCount);
    }

    private void validate(int purchasePrice) {
        if (purchasePrice % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void generateLottos(int lottoCount) {
        while (lottos.size() < lottoCount) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }
}
