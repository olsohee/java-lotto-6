package lotto.validator;


import lotto.message.ErrorMessage;

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
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_PRICE_FORMAT.getErrorMessage());
        }
    }
}
