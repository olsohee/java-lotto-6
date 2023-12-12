package lotto.domain;

import lotto.message.ErrorMessage;

public class PurchasePrice {

    private int purchasePrice;

    public PurchasePrice(int purchasePrice) {
        validate(purchasePrice);
        this.purchasePrice = purchasePrice;
    }

    private void validate(int purchasePrice) {
        if (purchasePrice % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_PRICE_UNIT.getErrorMessage());
        }
    }
}
