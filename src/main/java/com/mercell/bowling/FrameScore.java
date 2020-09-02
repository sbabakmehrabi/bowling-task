package com.mercell.bowling;

public class FrameScore {
    private int firstScore = -1;
    private int secondScore = -1;

    private int bonusPoint1 = -1;
    private int bonusPoint2 = -1;

    public FrameScore() {}

    public FrameScore(int firstScore) {
        this(firstScore, -1, -1, -1);
    }

    public FrameScore(int firstScore, int secondScore) {
        this(firstScore, secondScore, -1, -1);
    }

    public FrameScore(int firstScore, int secondScore, int bonusPoint1) {
        this(firstScore, secondScore, bonusPoint1, -1);
    }

    public FrameScore(int firstScore, int secondScore, int bonusPoint1, int bonusPoint2) {
        this.firstScore = firstScore;
        this.secondScore = secondScore;
        this.bonusPoint1 = bonusPoint1;
        this.bonusPoint2 = bonusPoint2;
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

    public int getBonusPoint1() {
        return bonusPoint1;
    }

    public void setBonusPoint1(int bonusPoint1) {
        this.bonusPoint1 = bonusPoint1;
    }

    public int getBonusPoint2() {
        return bonusPoint2;
    }

    public void setBonusPoint2(int bonusPoint2) {
        this.bonusPoint2 = bonusPoint2;
    }

    /**
     * this method will return true if the shot is strike
     * @return boolean
     */
    public boolean isStrike() {
        return firstScore == 10 && secondScore == -1;
    }

    /**
     * this method will return true if the shot is spare
     * Also, it checks if the shot is not a strike
     * @return boolean
     */
    public boolean isSpare() {
        return firstScore + secondScore == 10 && secondScore != -1;
    }
}

