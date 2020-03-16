package com.qwertywiz.tdd.tennisgame;

public class TennisGame {

    private String player1Name;
    private String player2Name;
    private final Referee referee = new Referee(new Score(0), new Score(0));

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1") {
            referee.score1.add();
        } else {
            referee.score2.add();
        }

    }

    public String getScore() {
        String score = "";
        if (referee.score1.value == referee.score2.value) {
            score = even();
        } else if (referee.isAfterDeuce()) {
            score = afterDeuce();
        } else {
            score = beforeDeuce();
        }
        return score;
    }

    private String beforeDeuce() {
        return referee.score1.trunslate() + "-" + referee.score2.trunslate();
    }

    private String afterDeuce() {
        String score = "";
        int minusResult = referee.score1.value - referee.score2.value;
        // Advantage
        if (minusResult == 1) {
            score = "Advantage " + this.player1Name;
        } else if (minusResult == -1) {
            score = caseA("Advantage ", this.player2Name);
        }

        // Win
        if (minusResult >= 2) {
            score = "Win for " + this.player1Name;
        } else if (minusResult <= -2) {
            score = "Win for " + this.player2Name;
        }
        return score;
    }

    private String caseA(String s, String player2Name) {
        String score;
        score = s + player2Name;
        return score;
    }

    private String even() {
        switch (referee.score1.value) {
            case 0:
            case 1:
            case 2:
                return referee.score1.trunslate() + "-All";
            default:
                return "Deuce";
        }
    }

}