package com.qwertywiz.tdd.vendingmachine;

import java.util.Objects;

public class Drink {
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drink drink = (Drink) o;
        return Objects.equals(name, drink.name);
    }
}
