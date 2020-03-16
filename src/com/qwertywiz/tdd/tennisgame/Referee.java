package com.qwertywiz.tdd.tennisgame;

public class Referee {
    public Score score1;
    public Score score2;

    public Referee(Score score1, Score score2) {

        this.score1 = score1;
        this.score2 = score2;
    }

    boolean isAfterDeuce() {
        return score1.value >= 4 || score2.value >= 4;
    }
}