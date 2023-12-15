package lotto.domain;

import lotto.message.ErrorMessage;

import java.util.List;

import static lotto.constant.LottoCondition.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
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

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    public int getWinningResult(Lotto winningLotto) {
        return (int) this.numbers.stream()
                .filter(number -> winningLotto.numbers.contains(number))
                .count();
    }

    public boolean getBonusResult(BonusNumber bonusNumber) {
        return bonusNumber.isContain(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
