package lotto.view;

import lotto.dto.LottoDto;
import lotto.message.OutputMessage;

import java.util.List;

public class OutputView {

    private static final String DELIMITER = ", ";

    private OutputView() {
    }

    private static class OutputViewHolder {
        private static OutputView outputView = new OutputView();
    }

    public static OutputView getInstance() {
        return OutputViewHolder.outputView;
    }

    public void printUserLotto(List<LottoDto> userLottoDto) {
        System.out.println(String.format(OutputMessage.PURCHASER_COUNT.getMessage(), userLottoDto.size()));
        userLottoDto.stream()
                .forEach(lottoDto -> System.out.println(String.format(
                        OutputMessage.USER_LOTTO.getMessage(),
                        String.join(DELIMITER, lottoDto.getLotto())))
                );
    }
}
