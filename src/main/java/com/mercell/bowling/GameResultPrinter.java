package com.mercell.bowling;

import java.util.List;

public class GameResultPrinter {

    private List<FrameScore> frameScores;

    public GameResultPrinter(List<FrameScore> frameScores) {
        this.frameScores = frameScores;
    }

    public void print() {
        printRoundsTable();
        printFrameScores();
        printTotalGameScore();
    }

    private void printRoundsTable() {
        for(int i = 1; i < BowlingConstants.MAXIMUM_TURNS_IN_EACH_TURN; i++) {
            System.out.print("| f" + i + " ");
        }
        System.out.println("| f10   |");
    }

    private void printFrameScores() {
        for(int i = 0; i < BowlingConstants.MAXIMUM_TURNS_IN_EACH_TURN; i++) {
            System.out.print("|" + formatFrameScore(i ));
        }
        System.out.println("|");
    }

    private void printTotalGameScore() {
        TotalScoreCalculator totalScoreCalculator = new TotalScoreCalculator(frameScores);
        System.out.print("score: " + totalScoreCalculator.calculate());
    }

    private String formatFrameScore(int i) {
        String firstScore = null;
        if(frameScores.get(i).isStrike()) {
            if(i == BowlingConstants.MAXIMUM_TURNS_IN_EACH_TURN - 1) {
                return "X, " + frameScores.get(i).getBonusPoint1() + ", " + frameScores.get(i).getBonusPoint2();
            }
            return "X   ";
        } else {
            firstScore = formatSingleScore(frameScores.get(i).getFirstScore());
        }


        String secondScore = null;
        if(frameScores.get(i).isSpare()) {
            secondScore = "/";
        } else {
            secondScore = formatSingleScore(frameScores.get(i).getSecondScore());
            if(i == BowlingConstants.MAXIMUM_TURNS_IN_EACH_TURN - 1) {
                return firstScore + ", " + secondScore + "   ";
            }
        }


        return firstScore + ", " + secondScore;
    }

    private String formatSingleScore(int score) {
        return score == 0 ? "-" : Integer.toString(score);
    }
}
