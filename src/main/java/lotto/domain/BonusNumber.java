package lotto.domain;

import java.util.List;

public class BonusNumber {

    private int bonusNumber;

    public BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public boolean isContain(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }
}
