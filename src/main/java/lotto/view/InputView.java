package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String READ_PURCHASE_PRICE = "구입금액을 입력해 주세요.";

    private InputView() {
    }

    private static class InputViewHolder {
        private static InputView inputView = new InputView();
    }

    public static InputView getInstance() {
        return InputViewHolder.inputView;
    }

    public String readPurchasePrice() {
        System.out.println(READ_PURCHASE_PRICE);
        return Console.readLine();
    }
}
