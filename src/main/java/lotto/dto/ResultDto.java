package lotto.dto;

import lotto.domain.Result;

import java.util.EnumMap;
import java.util.Map;

public class ResultDto {

    private final EnumMap<Result, Integer> results;
    private final double returnRate;

    public ResultDto(EnumMap<Result, Integer> results, double returnRate) {
        this.results = results;
        this.returnRate = returnRate;
    }

    public EnumMap<Result, Integer> getResults() {
        return results;
    }

    public double getReturnRate() {
        return returnRate;
    }
}
