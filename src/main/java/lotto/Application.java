package lotto;

import lotto.controller.Controller;
import lotto.service.Service;
import lotto.convertor.InputConvertor;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        Controller controller = new Controller(InputView.getInstance(), InputConvertor.getInstance(),
                OutputView.getInstance(), new Service());
        controller.start();
    }
}
