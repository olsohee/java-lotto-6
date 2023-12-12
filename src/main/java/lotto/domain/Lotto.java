package lotto.domain;

import lotto.message.ErrorMessage;

import java.util.List;

import static lotto.domain.LottoCondition.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateDuplicated(numbers);
        validateRange(numbers);
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_COUNT.getErrorMessage());
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        long nonDuplicatedCount = numbers.stream()
                .distinct()
                .count();
        if (nonDuplicatedCount != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATED.getErrorMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.stream()
                .forEach(number -> {
                    if (number < MIN_NUMBER.getValue() || number > MAX_NUMBER.getValue()) {
                        throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.getErrorMessage());
                    }
                });
    }

    public int getWinningResult(WinningLotto winningLotto) {
        return winningLotto.getWinningMatchCount(numbers);
    }

    public boolean getBonusResult(WinningLotto winningLotto) {
        return winningLotto.isMatchWithBonusNumber(numbers);
    }

    public int getMatchCount(List<Integer> userNumbers) {
        return (int) userNumbers.stream()
                .filter(userNumber -> numbers.contains(userNumber))
                .count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
