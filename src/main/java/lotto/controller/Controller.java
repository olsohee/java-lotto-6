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
        generateWinningLotto();
        drawLotto();
    }

    private void buyLotto() {
        try {
            int purchasePrice = inputValidator.convertStringToInt(inputView.readPurchasePrice());
            service.buyUserLotto(purchasePrice);
            outputView.printUserLotto(service.getUserLottoDto());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            buyLotto();
        }
    }

    private void generateWinningLotto() {
        try {
            List<Integer> winningLotto = Arrays.stream(inputView.readWinningLotto().split(","))
                    .map(input -> inputValidator.convertStringToInt(input.trim()))
                    .toList();
            int bonusNumber = inputValidator.convertStringToInt(inputView.readBonusNumber());
            service.generateWinningLotto(winningLotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            generateWinningLotto();
        }
    }

    private void drawLotto() {
        service.draw();
        outputView.printResult(service.getResultDto());
    }
}
