package lotto.dto;

import lotto.domain.Ranking;

import java.util.EnumMap;

public class ResultDto {

    private final EnumMap<Ranking, Integer> rankings;
    private final double returnRate;

    public ResultDto(EnumMap<Ranking, Integer> rankings, double returnRate) {
        this.rankings = rankings;
        this.returnRate = returnRate;
    }

    public EnumMap<Ranking, Integer> getRankings() {
        return rankings;
    }

    public double getReturnRate() {
        return returnRate;
    }
}
