package lotto.view;

import lotto.domain.Ranking;
import lotto.dto.LottoDto;
import lotto.dto.ResultDto;
import lotto.message.OutputMessage;

import java.util.EnumMap;
import java.util.List;

public class OutputView {

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
                        String.join(OutputMessage.DELIMITER.getMessage(), lottoDto.getLotto())))
                );
    }

    public void printResult(ResultDto resultDto) {
        System.out.println();
        System.out.println(OutputMessage.PRINT_RESULT_MESSAGE.getMessage());

        EnumMap<Ranking, Integer> results = resultDto.getRankings();
        for (Ranking ranking : results.keySet()) {
            System.out.println(String.format(
                    OutputMessage.RESULT.getMessage(), ranking.getMessage(), results.get(ranking)));
        }

        System.out.println(String.format(
                OutputMessage.RETURN_RATE.getMessage(), resultDto.getReturnRate()));
    }
}
