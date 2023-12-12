package lotto.domain;

import java.util.List;

public class UserLotto {

    private final List<Lotto> userLotto;

    public UserLotto(List<Lotto> userLotto) {
        this.userLotto = userLotto;
    }

    public List<Lotto> getUserLotto() {
        return userLotto;
    }
}
