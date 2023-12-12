package lotto.dto;

import java.util.List;

public class LottoDto {
    private final List<String> lotto;

    public LottoDto(List<Integer> lotto) {
        this.lotto = lotto.stream()
                .map(number -> String.valueOf(number))
                .toList();
    }

    public List<String> getLotto() {
        return lotto;
    }
}
