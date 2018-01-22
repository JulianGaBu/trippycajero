package com.lambda.Resources.Reports;

import com.lambda.Resources.Entities.Purchase;

import java.text.DecimalFormat;

public class PurchaseReport extends Report {
    private Purchase purchase;
    private int quantity;
    private int cashierNum;

    public PurchaseReport(Purchase purchase, double total, int time, int quantity, int cashierNum) {
        this.purchase = purchase;
        this.total = total;
        this.time = time;
        this.quantity = quantity;
        this.cashierNum = cashierNum;
    }

    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.00");
        return "Client #" + purchase.id +
                (this.cashierNum != 0 ? " xx Caja " + this.cashierNum + "[[" : "") +
                "(" + quantity + " items) " +
                " Total: $" + df.format(this.total) + ", Time: " + this.time + " s]]";
    }
}
