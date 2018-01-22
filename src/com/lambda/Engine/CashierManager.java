package com.lambda.Engine;

import com.lambda.Resources.Entities.*;
import com.lambda.Resources.Reports.FullReport;
import com.lambda.Resources.Reports.PurchaseReport;
import com.lambda.Resources.Reports.Report;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class CashierManager {
    private FullReport fullReport;
    private ArrayList<PurchaseReport> purchaseReports;
    private final ExecutorService cashiers;

    public CashierManager(int cashiers) {
        fullReport = new FullReport();
        purchaseReports = new ArrayList<>();
        this.cashiers = Executors.newFixedThreadPool(cashiers);
    }

    public void startServing(ArrayList<Purchase> purchases){
        for (Purchase purchase : purchases){
            processPurchase(purchase);
        }
    }

    public void stopServing(){
        this.cashiers.shutdown();
        try {
            cashiers.awaitTermination(60, TimeUnit.SECONDS);
            printReport(fullReport);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void processPurchase(Purchase purchase){
        // Threaded report generation for each purchase
        Thread thread = new Thread(() -> {
            int cashierNum = Integer.valueOf(Thread.currentThread().getName().split("[-]")[3]);
            double purchaseTotal = 0;
            int purchaseTime = 0;

            System.out.println("Client #" + purchase.id + " -> Caja " + cashierNum);

            for (Item item : purchase.items){
                purchaseTotal += item.price;
                purchaseTime += item.time;
            }

            PurchaseReport purchaseReport = new PurchaseReport(purchase, purchaseTotal, purchaseTime, purchase.items.size(), cashierNum);
            purchaseReports.add(purchaseReport);
            fullReport.update(purchaseTotal,purchaseTime);
            try {
                Thread.sleep(purchaseTime*100);
                printReport(purchaseReport);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        this.cashiers.execute(thread);
    }

    private void printReport(Report report){
        System.out.println(report);
    }
}
