package lotto.service;

import lotto.domain.PurchasePrice;

public class Service {

    private PurchasePrice purchasePrice;

    public void createPurchasePrice(int purchasePrice) {
        this.purchasePrice = new PurchasePrice(purchasePrice);
    }
}
