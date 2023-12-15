package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;

public class WinningResult {

    private EnumMap<Ranking, Integer> rankings = new EnumMap<>(Ranking.class);
    private double returnRate;

    public WinningResult(Lottos userLottos, Lotto winningLotto, BonusNumber bonusNumber, PurchasePrice purchasePrice) {
        setRankings(userLottos, winningLotto, bonusNumber);
        setReturnRate(purchasePrice);
    }

    private void setRankings(Lottos lottos, Lotto winningLotto, BonusNumber bonusNumber) {
        Arrays.stream(Ranking.values())
                .forEach(ranking -> rankings.put(ranking, 0));

        lottos.draw(winningLotto, bonusNumber).stream()
                .forEach(result -> rankings.put(result, rankings.get(result) + 1));
    }

    private void setReturnRate(PurchasePrice purchasePrice) {
        double totalProfitAmount = 0;
        for (Ranking ranking : rankings.keySet()) {
            totalProfitAmount += ranking.getProfitAmount() * rankings.get(ranking);
        }
        returnRate = (totalProfitAmount / purchasePrice.getPurchasePrice()) * 100;
    }

    public EnumMap<Ranking, Integer> getRankings() {
        return rankings;
    }

    public double getReturnRate() {
        return returnRate;
    }
}
