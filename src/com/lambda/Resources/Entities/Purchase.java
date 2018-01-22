package com.lambda.Resources.Entities;

import java.util.ArrayList;
import java.util.Arrays;

public class Purchase {
    public int id;
    public ArrayList<Item> items;

    public Purchase(Item... items){
        this.items = new ArrayList<>();
        this.items.addAll(Arrays.asList(items));
    }

    public Purchase(int id, Item... items){
        this.id = id;
        this.items = new ArrayList<>();
        this.items.addAll(Arrays.asList(items));
    }

    public Purchase(ArrayList<Item> items){
        this.items = items;
    }

    public Purchase(int id, ArrayList<Item> items){
        this.id = id;
        this.items = items;
    }
}
