package lotto.view;

import lotto.domain.Result;
import lotto.dto.LottoDto;
import lotto.dto.ResultDto;
import lotto.message.OutputMessage;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

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

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printUserLotto(List<LottoDto> userLottoDto) {
        System.out.println();
        System.out.println(String.format(OutputMessage.PURCHASER_COUNT.getMessage(), userLottoDto.size()));
        userLottoDto.stream()
                .forEach(lottoDto -> System.out.println(String.format(
                        OutputMessage.USER_LOTTO.getMessage(),
                        String.join(DELIMITER, lottoDto.getLotto())))
                );
    }

    public void printResult(ResultDto resultDto) {
        System.out.println();
        System.out.println(OutputMessage.PRINT_RESULT_MESSAGE.getMessage());

        EnumMap<Result, Integer> results = resultDto.getResults();
        for (Result result : results.keySet()) {
            System.out.println(String.format(
                    OutputMessage.RESULT.getMessage(), result.getMessage(), results.get(result)));
        }

        System.out.println(String.format(
                OutputMessage.RETURN_RATE.getMessage(), resultDto.getReturnRate()));
    }
}
