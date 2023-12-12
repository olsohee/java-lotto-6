package lotto.domain;

import lotto.message.ErrorMessage;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_COUNT.getErrorMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
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
                    if (number < 1 || number > 45) {
                        throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.getErrorMessage());
                    }
                });
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
