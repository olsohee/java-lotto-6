package lotto.message;

public enum ErrorMessage {

    INVALID_PURCHASE_PRICE_FORMAT("구입 금액은 숫자여야 합니다."),
    INVALID_PURCHASE_PRICE_UNIT("구입 금액은 1000원 단위여야 합니다."),
    INVALID_INPUT("");

    private static final String ERROR_HEADER = "[ERROR]";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return String.format("%s %s", ERROR_HEADER, errorMessage);
    }
}
