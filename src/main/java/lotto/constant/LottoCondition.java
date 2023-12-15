package lotto.constant;

public enum LottoCondition {

    MIN_NUMBER(1),
    MAX_NUMBER(45),
    LOTTO_NUMBER_COUNT(6),
    LOTTO_PRICE(1000);

    private final int value;

    LottoCondition(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
