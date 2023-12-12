package lotto.domain;

import lotto.message.ErrorMessage;

import java.util.List;

public class Lotto {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
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
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
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
                    if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
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
