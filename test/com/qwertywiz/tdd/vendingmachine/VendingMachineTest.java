package com.qwertywiz.tdd.vendingmachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineTest {

    private VendingMachine machineStockEmpty;
    private VendingMachine machineStock1;
    private VendingMachine machineStockMax;

    @BeforeEach
    void setup() {
        machineStockEmpty = new VendingMachine();

        machineStock1 = new VendingMachine();
        machineStock1.addStock(new Water(), 0);
        machineStock1.addStock(new Coke(), 1);

        machineStockMax = new VendingMachine();
        for (int count = 0; count < 64; count++) {
            machineStockMax.addStock(new Water(), 0);
            machineStockMax.addStock(new Coke(), 1);
        }
    }

    @Nested
    class 在庫管理シナリオ {

        @Test
        void 在庫なしに水１つ追加() {
            machineStockEmpty.addStock(new Water(), 0);
            assertEquals(1, machineStockEmpty.viewStock(0));
        }

        @Test
        void 在庫なしにコーラ１つ追加() {
            machineStockEmpty.addStock(new Coke(), 1);
            assertEquals(1, machineStockEmpty.viewStock(1));
        }

        @Test
        void 在庫MAXに水１つ追加しようとしたらもう追加できない() {
            assertEquals(64, machineStockMax.viewStock(0));
            machineStockMax.addStock(new Water(), 0);
            assertEquals(64, machineStockMax.viewStock(0));
        }
    }

    @Nested
    class 購入シナリオ {
        @Test
        void 水100円を買っておつりなしパターン() {
            machineStock1.insertMoney(Coin._100);
            assertEquals(new Water(), machineStock1.buy(0));
            assertEquals(0, machineStock1.getCredit());
            assertEquals(Arrays.asList(), machineStock1.returnChange());
        }

        @Test
        void コーラ120円を買っておつり80円パターン() {
            machineStock1.insertMoney(Coin._100);
            machineStock1.insertMoney(Coin._100);
            assertEquals(new Coke(), machineStock1.buy(1));
            assertEquals(80, machineStock1.getCredit());
            assertEquals(Arrays.asList(Coin._50, Coin._10, Coin._10, Coin._10), machineStock1.returnChange());
        }

        @Test
        void 水買おうとしたが在庫なしで全額返却() {
            machineStockEmpty.insertMoney(Coin._500);
            assertEquals(null, machineStockEmpty.buy(0));
            assertEquals(500, machineStockEmpty.getCredit());
            assertEquals(Arrays.asList(Coin._500), machineStockEmpty.returnChange());
        }

    }

    @Nested
    class お金を投入するシナリオ {

        @ParameterizedTest
        @EnumSource(Coin.class)
        void コイン入れてみたパターン(Coin coin) {
            machineStock1.insertMoney(coin);
            assertEquals(coin.value, machineStock1.getCredit());
        }

        @ParameterizedTest
        @EnumSource(Bill.class)
        void 紙幣入れてみたパターン(Bill bill) {
            machineStock1.insertMoney(bill);
            assertEquals(bill.value, machineStock1.getCredit());
        }

    }

    @Test
    void ディスプレイを出力してみる() {
        assertEquals("[0]water: 100円 残数1\n"
                + "[1]coke: 120円 残数1\n", machineStock1.printStockAll());
    }

}