package com.qwertywiz.tdd.vendingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VendingMachine {

    private static final int STOCK_MAX = 64;
    private static final List<Money> validMoney = Arrays.asList(Bill._1000, Coin._500, Coin._100, Coin._50, Coin._10);
    private Display[] displays;
    private int credit;

    public VendingMachine() {
        Display display00 = new Display("water", 100);
        Display display01 = new Display("coke", 120);
        displays = new Display[]{display00, display01};
    }

    public Money insertMoney(Money input) {
        if (validMoney.contains(input)) {
            credit += input.getValue();
            return null;
        }
        return input;
    }

    public List<Money> returnChange() {
        int charge = credit;
        credit = 0;
        return toMoneyList(charge);
    }

    private List<Money> toMoneyList(int charge) {

        List<Money> returnMoney = new ArrayList<>();
        for (Money element : validMoney) {
            for (int i = 0; i < charge / element.getValue(); i++) {
                returnMoney.add(element);
            }
            charge %= element.getValue();
        }
        return returnMoney;
    }

    public Drink buy(int displayNo) {
        if (displays[displayNo].stockList.size() > 0) {
            List<Drink> stockList = displays[displayNo].stockList;
            credit -= displays[displayNo].value;
            return stockList.remove(stockList.size() - 1);
        }
        return null;
    }

    protected void addStock(Drink drink, int index) {
        if (displays[index].stockList.size() < STOCK_MAX) {
            displays[index].addStock(drink);
        }
    }

    protected int viewStock(int displayNo) {
        return displays[displayNo].stockList.size();
    }

    protected String printStockAll() {
        String print = "";
        for (int index = 0; index < displays.length; index++) {
            print = print + "[" + index + "]" + displays[index].itemName + ": " + displays[index].value + "円 残数" + displays[index].stockList.size();
            print = print + "\n";
        }
        return print;
    }

    public int getCredit() {
        return credit;
    }
}
