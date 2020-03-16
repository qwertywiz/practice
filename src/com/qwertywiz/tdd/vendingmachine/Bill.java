package com.qwertywiz.tdd.vendingmachine;

public enum Bill implements Money {
    _1000(1000),
    _invalid(0);

    public int value = 0;

    Bill(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }
}
