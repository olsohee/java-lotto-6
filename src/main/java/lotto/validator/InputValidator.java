package lotto.validator;


import lotto.message.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public class InputValidator {

    private InputValidator() {
    }

    private static class InputValidatorHolder {
        private static InputValidator inputValidator = new InputValidator();
    }

    public static InputValidator getInstance() {
        return InputValidatorHolder.inputValidator;
    }

    public int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_INPUT.getErrorMessage());
        }
    }

    public List<Integer> getWinningLotto(String input) {
        return Arrays.stream(input.split(","))
                .map(inputNumber -> convertStringToInt(inputNumber))
                .toList();
    }
}
