package com.qwertywiz.tdd.fizzbuzz;

public class FizzBuzzMaker {

    public String fizzBuzz(final int i) {
        if (i % 15 == 0) {
            return "FizzBuzz";
        } else if (i % 3 == 0) {
            return "Fizz";
        } else if (i % 5 == 0) {
            return "Buzz";
        }
        return String.valueOf(i);
    }
}
