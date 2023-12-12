package lotto;

import lotto.controller.Controller;
import lotto.service.Service;
import lotto.validator.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        Controller controller = new Controller(InputView.getInstance(), InputValidator.getInstance(),
                OutputView.getInstance(), new Service());
        controller.start();
    }
}
