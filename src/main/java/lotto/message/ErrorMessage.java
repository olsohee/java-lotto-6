package lotto.message;

public enum ErrorMessage {

    INVALID_NUMBER_INPUT("숫자로 입력해야 합니다."),
    INVALID_PURCHASE_PRICE_UNIT("구입 금액은 1000원 단위여야 합니다."),
    INVALID_LOTTO_COUNT("로또는 6개의 숫자여야 합니다."),
    LOTTO_DUPLICATED("로또 번호는 중복될 수 없습니다."),
    INVALID_RANGE("1 ~ 45 사이의 숫자여야 합니다."),
    BONUS_NUMBER_DUPLICATED("보너스 번호는 로또 번호와 중복될 수 없습니다.")
    ;

    private static final String ERROR_HEADER = "[ERROR]";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return String.format("%s %s", ERROR_HEADER, errorMessage);
    }
}
