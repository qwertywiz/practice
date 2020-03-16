package com.qwertywiz.tdd.tennisgame;

public class Score {
    public int value;

    public Score(int value) {
        this.value = value;
    }

    String trunslate() {
        switch (value) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }
        return "";
    }

    public void add() {
        value++;
    }
}