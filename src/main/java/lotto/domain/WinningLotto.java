package lotto.domain;

import lotto.message.ErrorMessage;

import java.util.List;

public class WinningLotto {

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningLotto, int bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = new Lotto(winningLotto);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> winningLotto, int bonusNumber) {
        validateDuplicated(winningLotto, bonusNumber);
        validateRange(bonusNumber);
    }

    private void validateDuplicated(List<Integer> answerLotto, int bonusNumber) {
        boolean isDuplicated = answerLotto.stream()
                .anyMatch(number -> bonusNumber == number);
        if (isDuplicated) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATED.getErrorMessage());
        }
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE.getErrorMessage());
        }
    }

    public int getWinningMatchCount(List<Integer> userNumbers) {
        return winningLotto.getWinningMatchCount(userNumbers);
    }

    public boolean getBonusResult(List<Integer> userNumbers) {
        return userNumbers.contains(bonusNumber);
    }
}
