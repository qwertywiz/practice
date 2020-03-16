package com.qwertywiz.tdd.vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class Display {
    protected int value;
    protected String itemName;
    protected List<Drink> stockList = new ArrayList<>();

    public Display(String itemName, int value) {
        this.itemName = itemName;
        this.value = value;
    }

    public void addStock(Drink drink) {
        stockList.add(drink);
    }
}
