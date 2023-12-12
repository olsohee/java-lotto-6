package lotto.convertor;


import lotto.message.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public class InputConvertor {

    private InputConvertor() {
    }

    private static class InputConvertorHolder {
        private static InputConvertor inputConvertor = new InputConvertor();
    }

    public static InputConvertor getInstance() {
        return InputConvertorHolder.inputConvertor;
    }

    public int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_INPUT.getErrorMessage());
        }
    }

    public List<Integer> getWinningLotto(String input) {
        return Arrays.stream(input.split(","))
                .map(inputNumber -> convertToInt(inputNumber))
                .toList();
    }
}
