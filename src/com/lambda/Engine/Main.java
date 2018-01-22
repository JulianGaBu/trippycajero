package com.lambda.Engine;

import com.lambda.Resources.Entities.Purchase;

import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        int cashierCount = 3;
        CashierManager cashierManager = new CashierManager(cashierCount);
        PurchaseFactory purchaseFactory = new PurchaseFactory();

        // Random input generation
        ArrayList<Purchase> purchases = purchaseFactory.generate();

        // Async execution
        cashierManager.startServing(purchases);

        // Block orderly shutdown
        cashierManager.stopServing();

    }
}
