package lotto.controller;

import lotto.service.Service;
import lotto.convertor.InputConvertor;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class Controller {

    private final InputView inputView;
    private final InputConvertor inputConvertor;
    private final OutputView outputView;
    private final Service service;

    public Controller(InputView inputView, InputConvertor inputConvertor, OutputView outputView, Service service) {
        this.inputView = inputView;
        this.inputConvertor = inputConvertor;
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
            int purchasePrice = inputConvertor.convertToInt(inputView.readPurchasePrice());
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
                    .map(input -> inputConvertor.convertToInt(input.trim()))
                    .toList();
            int bonusNumber = inputConvertor.convertToInt(inputView.readBonusNumber());
            service.generateWinningLotto(winningLotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            generateWinningLotto();
        }
    }

    private void drawLotto() {
        service.generateWinningResult();
        outputView.printResult(service.getResultDto());
    }
}
