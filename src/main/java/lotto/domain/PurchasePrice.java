package lotto.domain;

import lotto.message.ErrorMessage;

import static lotto.domain.LottoCondition.LOTTO_PRICE;

public class PurchasePrice {

    private final int purchasePrice;

    public PurchasePrice(int purchasePrice) {
        validate(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    private void validate(int purchasePrice) {
        if (purchasePrice % LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_PRICE_UNIT.getErrorMessage());
        }
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }
}
