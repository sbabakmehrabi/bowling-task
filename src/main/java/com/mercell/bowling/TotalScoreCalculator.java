package com.mercell.bowling;

import java.util.List;

public class TotalScoreCalculator {

    private final int MAXIMUM_SCORE_IN_EACH_TURN = 10;

    List<FrameScore> frameScores;

    public TotalScoreCalculator(List<FrameScore> frameScores) {
        this.frameScores = frameScores;
    }

    public int calculate() {

        int totalScore = 0;

        for(int i=0; i < frameScores.size(); i++ ) {
            FrameScore frameScore = frameScores.get(i);

            if(frameScore.isStrike()) {
                totalScore += calculateStrikeScoreForFrame(i);
            } else if(frameScore.isSpare()) {
                totalScore += calculateSpareScoreForFrame(i);
            } else {
                totalScore += frameScore.getFirstScore() + frameScore.getSecondScore();
            }
        }

        return totalScore;
    }

    private int calculateStrikeScoreForFrame(int i) {
        if(i == frameScores.size() - 1) {
            return MAXIMUM_SCORE_IN_EACH_TURN + frameScores.get(i).getBonusPoint1() + frameScores.get(i).getBonusPoint2();
        }
        return MAXIMUM_SCORE_IN_EACH_TURN +
                frameScores.get(i + 1).getFirstScore() + frameScores.get(i + 1).getSecondScore();
    }

    private int calculateSpareScoreForFrame(int i) {
        if(i == frameScores.size() - 1) {
            return MAXIMUM_SCORE_IN_EACH_TURN + frameScores.get(i).getBonusPoint1();
        }
        return MAXIMUM_SCORE_IN_EACH_TURN + frameScores.get(i + 1).getFirstScore();
    }
}
