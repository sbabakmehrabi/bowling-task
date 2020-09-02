package com.mercell.bowling;

public class FrameScore {
    private int firstScore = -1;
    private int secondScore = -1;

    public FrameScore() {}

    public FrameScore(int firstScore) {
        this.firstScore = firstScore;
    }

    public FrameScore(int firstScore, int secondScore) {
        this.firstScore = firstScore;
        this.secondScore = secondScore;
    }

    public int getFirstScore() {
        return firstScore;
    }

    public void setFirstScore(int firstScore) {
        this.firstScore = firstScore;
    }

    public int getSecondScore() {
        return secondScore;
    }

    public void setSecondScore(int secondScore) {
        this.secondScore = secondScore;
    }

    public boolean isStrike() {
        return firstScore == 10 && secondScore == -1;
    }
}

