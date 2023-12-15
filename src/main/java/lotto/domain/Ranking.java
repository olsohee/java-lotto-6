package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Ranking {

    FAIL("탈락",
            (lotto, winningLotto, bonusNumber) -> lotto.getWinningResult(winningLotto) == 0,
    0),
    FIFTH("3개 일치 (5,000원)",
            (lotto, winningLotto, bonusNumber) -> lotto.getWinningResult(winningLotto) == 3,
            5000),
    FOURTH("4개 일치 (50,000원)",
            (lotto, winningLotto, bonusNumber) -> lotto.getWinningResult(winningLotto) == 4,
            50000),
    THIRD("5개 일치 (1,500,000원)",
            (lotto, winningLotto, bonusNumber) -> lotto.getWinningResult(winningLotto) == 5,
            1500000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)",
            (lotto, winningLotto, bonusNumber) -> lotto.getWinningResult(winningLotto) == 5 && lotto.getBonusResult(bonusNumber),
            30000000),
    FIRST("6개 일치 (2,000,000,000원)",
            (lotto, winningLotto, bonusNumber) -> lotto.getWinningResult(winningLotto) == 6,
            2000000000),
    ;

    private final String message;
    private final TriPredicate<Lotto, Lotto, BonusNumber> isApplicable;
    private final int profitAmount;

    Ranking(String message, TriPredicate<Lotto, Lotto, BonusNumber> isApplicable, int profitAmount) {
        this.message = message;
        this.isApplicable = isApplicable;
        this.profitAmount = profitAmount;
    }

    public static Ranking getResult(Lotto lotto, Lotto winningLotto, BonusNumber bonusNumber) {
        return Arrays.stream(Ranking.values())
                .filter(result -> result.isApplicable.test(lotto, winningLotto, bonusNumber))
                .findAny()
                .orElse(Ranking.FAIL);
    }

    public int getProfitAmount() {
        return profitAmount;
    }

    public String getMessage() {
        return message;
    }
}
