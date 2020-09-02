package com.mercell.bowling;

import java.util.ArrayList;
import java.util.List;

public class SequenceToFrameScoreConverter {

    private final static int SCORE_IN_STRIKE_SHOT = 10;

    public List<FrameScore> convert(List<Integer> rawScores) {
        List<FrameScore> frameScores = new ArrayList<>();

        FrameScore frameScore = new FrameScore();
        boolean thisIsFirstShotOfFrame = true;
        for(Integer shot: rawScores) {
            if(thisIsFirstShotOfFrame) {
                frameScore = new FrameScore();
                frameScore.setFirstScore(shot);
                thisIsFirstShotOfFrame = false;

                if(shot == SCORE_IN_STRIKE_SHOT) {
                    frameScores.add(frameScore);
                    thisIsFirstShotOfFrame = true;
                }

            } else {
                frameScore.setSecondScore(shot);
                frameScores.add(frameScore);

                thisIsFirstShotOfFrame = true;
            }
        }

        return frameScores;
    }
}
