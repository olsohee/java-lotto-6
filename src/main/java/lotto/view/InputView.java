package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String READ_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String READ_WINNING_LOTTO = "당첨 번호를 입력해 주세요.";
    private static final String READ_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

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

    public String readWinningLotto() {
        System.out.println();
        System.out.println(READ_WINNING_LOTTO);
        return Console.readLine();
    }

    public String readBonusNumber() {
        System.out.println();
        System.out.println(READ_BONUS_NUMBER);
        return Console.readLine();
    }
}
