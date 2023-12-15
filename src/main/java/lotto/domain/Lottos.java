package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Ranking> draw(Lotto winningLotto, BonusNumber bonusNumber) {
        List<Ranking> rankings = new ArrayList<>();
        for (Lotto lotto : lottos) {
            rankings.add(Ranking.getResult(lotto, winningLotto, bonusNumber));
        }
        return rankings;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
