package lotto.controller;

import lotto.service.Service;
import lotto.validator.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class Controller {

    private final InputView inputView;
    private final InputValidator inputValidator;
    private final OutputView outputView;
    private final Service service;

    public Controller(InputView inputView, InputValidator inputValidator, OutputView outputView, Service service) {
        this.inputView = inputView;
        this.inputValidator = inputValidator;
        this.outputView = outputView;
        this.service = service;
    }

    public void start() {
        buyLotto();
        drawLotto();
    }

    private void buyLotto() {
        int purchasePrice = inputValidator.convertStringToInt(inputView.readPurchasePrice());
        service.createPurchasePrice(purchasePrice);
        service.createUserLotto(purchasePrice);
        outputView.printUserLotto(service.getUserLottoDto());
    }

    private void drawLotto() {
        List<Integer> winningLotto = Arrays.stream(inputView.readWinningLotto().split(","))
                .map(input -> inputValidator.convertStringToInt(input.trim()))
                .toList();
        int bonusNumber = inputValidator.convertStringToInt(inputView.readBonusNumber());
        service.createWinningLotto(winningLotto, bonusNumber);
        service.draw();
    }
}
