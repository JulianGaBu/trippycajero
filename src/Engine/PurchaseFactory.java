package Engine;

import Resources.Entities.Item;
import Resources.Entities.Purchase;

import java.util.ArrayList;

public class PurchaseFactory {
    private int clients;

    public PurchaseFactory(){
        clients = randomRange(5,15);
    }

    public PurchaseFactory(int clients){
        this.clients = clients;
    }

    public ArrayList<Purchase> generate(){
        ArrayList<Purchase> purchases = new ArrayList<>();
        for (int $purchase = 0; $purchase < clients; $purchase++) {
            ArrayList<Item> items = new ArrayList<>();
            for (int $item = 0; $item < randomRange(1, 20); $item++) {
                items.add(new Item($item, randomRange(1, 199.9), randomRange(1, 15)));
            }
            purchases.add(new Purchase($purchase, items));
        }
        return purchases;
    }

    public void setClients(int clients) {
        this.clients = clients;
    }

    // random int
    private static int randomRange(int min, int max) {
        int range = Math.abs(max - min) + 1;
        return (int) (Math.random() * range) + (min <= max ? min : max);
    }

    // random double
    private static double randomRange(double min, double max) {
        double range = Math.abs(max - min);
        return (Math.random() * range) + (min <= max ? min : max);
    }
}
