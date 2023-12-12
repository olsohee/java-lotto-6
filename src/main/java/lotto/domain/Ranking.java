package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Ranking {

    FAIL("탈락",
            (lotto, winningLotto) -> lotto.getWinningResult(winningLotto) == 0,
    0),
    FIFTH("3개 일치 (5,000원)",
            (lotto, winningLotto) -> lotto.getWinningResult(winningLotto) == 3,
            5000),
    FOURTH("4개 일치 (50,000원)",
            (lotto, winningLotto) -> lotto.getWinningResult(winningLotto) == 4,
            50000),
    THIRD("5개 일치 (1,500,000원)",
            (lotto, winningLotto) -> lotto.getWinningResult(winningLotto) == 5,
            1500000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)",
            (lotto, winningLotto) -> lotto.getWinningResult(winningLotto) == 5 && lotto.getBonusResult(winningLotto),
            30000000),
    FIRST("6개 일치 (2,000,000,000원)",
            (lotto, winningLotto) -> lotto.getWinningResult(winningLotto) == 6,
            2000000000),
    ;

    private final String message;
    private final BiPredicate<Lotto, WinningLotto> isApplicable;
    private final int profitAmount;

    Ranking(String message, BiPredicate<Lotto, WinningLotto> isApplicable, int profitAmount) {
        this.message = message;
        this.isApplicable = isApplicable;
        this.profitAmount = profitAmount;
    }

    public static Ranking getResult(Lotto lotto, WinningLotto winningLotto) {
        return Arrays.stream(Ranking.values())
                .filter(result -> result.isApplicable.test(lotto, winningLotto))
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
