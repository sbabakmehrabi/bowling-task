package com.mercell.bowling;

import java.util.ArrayList;
import java.util.List;

public class SequenceToFrameScoreConverter {

    /**
     * This method identifies if each turn consists of two shots or one shot (strike shots) and
     * returns a list of FrameScores
     * @param rawScores List<Integer>
     * @return List<FrameScore>
     */
    public List<FrameScore> convert(List<Integer> rawScores) {
        List<FrameScore> frameScores = new ArrayList<>();

        FrameScore frameScore = new FrameScore();
        boolean thisIsFirstShotOfFrame = true;
        int turnIndex = 1;
        for(int i=0; i < rawScores.size(); i++) {

            Integer shot = rawScores.get(i);

            // check if we are working on the last shot.
            // The reading process would be different if the last shot is a spare or strike shot
            if(turnIndex == BowlingConstants.MAXIMUM_TURNS_IN_EACH_TURN) {
                //if this is a strike shot
                FrameScore newFrameScore = createFrameScoreForTheLastShot(rawScores, i);
                if(newFrameScore != null) {
                    frameScores.add(newFrameScore);
                    break;
                }

            }

            if(thisIsFirstShotOfFrame) {
                frameScore = new FrameScore();
                frameScore.setFirstScore(shot);
                thisIsFirstShotOfFrame = false;

                if(shot == BowlingConstants.SCORE_IN_STRIKE_SHOT) {
                    frameScores.add(frameScore);
                    turnIndex++;
                    thisIsFirstShotOfFrame = true;
                }

            } else {
                frameScore.setSecondScore(shot);
                frameScores.add(frameScore);
                turnIndex++;

                thisIsFirstShotOfFrame = true;
            }
        }

        return frameScores;
    }

    private FrameScore createFrameScoreForTheLastShot(List<Integer> rawScores, int i) {
        Integer shot = rawScores.get(i);
        if(shot == BowlingConstants.SCORE_IN_STRIKE_SHOT) {
            return new FrameScore(shot, -1, rawScores.get(i + 1), rawScores.get(i + 2));
        }
        // if we this is a spare shot
        if(i + 1 < rawScores.size() && shot + rawScores.get(i + 1) == BowlingConstants.MAXIMUM_SCORE_IN_EACH_TURN) {
            return new FrameScore(shot, rawScores.get(i + 1), rawScores.get(i + 2));
        }
        return null;
    }
}
