package com.qwertywiz.tdd.vendingmachine;

public enum Coin implements Money {
    _10(10),
    _50(50),
    _100(100),
    _500(500),
    _invalid(0);

    public int value;

    Coin(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }
}
