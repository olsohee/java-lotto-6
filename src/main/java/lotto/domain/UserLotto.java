package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class UserLotto {

    private final List<Lotto> userLotto;

    public UserLotto(List<Lotto> userLotto) {
        this.userLotto = userLotto;
    }

    public List<Lotto> getUserLotto() {
        return userLotto;
    }

    public List<Ranking> draw(WinningLotto winningLotto) {
        List<Ranking> rankings = new ArrayList<>();
        userLotto.stream()
                .forEach(lotto -> rankings.add(Ranking.getResult(lotto, winningLotto)));
        return rankings;
    }
}
