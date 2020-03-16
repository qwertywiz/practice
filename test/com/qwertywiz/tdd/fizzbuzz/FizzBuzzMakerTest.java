package com.qwertywiz.tdd.fizzbuzz;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzMakerTest {

    private static FizzBuzzMaker maker;

    @BeforeAll
    static void setup() {
        maker = new FizzBuzzMaker();
    }

    @ParameterizedTest
    @CsvSource({
            "0, FizzBuzz,  入力0／出力FizzBuzzを返却",
            "1, 1,         入力1／出力1を返却",
            "2, 2,         入力2／出力2を返却",
            "3, Fizz,      入力3／出力Fizzを返却",
            "5, Buzz,      入力5／出力Buzzを返却",
            "15, FizzBuzz, 入力15／出力FizzBuzzを返却",
            "30, FizzBuzz, 入力30／出力FizzBuzzを返却",
    })
    void 正常系パターン(int input, String expected, String message) {
        assertEquals(expected, maker.fizzBuzz(input), message);
    }

}
