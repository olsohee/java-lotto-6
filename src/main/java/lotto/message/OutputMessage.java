package lotto.message;

public enum OutputMessage {

    PURCHASER_COUNT("%d개를 구매했습니다."),
    USER_LOTTO("[%s]"),
    DELIMITER(", "),
    PRINT_RESULT_MESSAGE("당첨 통계\n---"),
    RESULT("%s - %d개"),
    RETURN_RATE("총 수익률은 %,.1f%%입니다.")
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
