package lotto.message;

public enum OutputMessage {

    PURCHASER_COUNT("%d개를 구매했습니다."),
    USER_LOTTO("[%s]"),
    DELIMITER(", ")
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
