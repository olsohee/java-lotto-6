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

    public List<Result> draw(WinningLotto winningLotto) {
        List<Result> results = new ArrayList<>();
        userLotto.stream()
                .forEach(lotto -> results.add(Result.getResult(lotto, winningLotto)));
        return results;
    }
}
