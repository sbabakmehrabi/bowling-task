package com.mercell.bowling;

import java.util.ArrayList;
import java.util.List;

public class SequenceToFrameScoreConverter {

    private final static int SCORE_IN_STRIKE_SHOT = 10;
    private final static int MAX_SHOT_COUNTS_IN_BOWLING = 10;

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
            if(turnIndex == MAX_SHOT_COUNTS_IN_BOWLING) {
                //if this is a strike shot
                if(shot == SCORE_IN_STRIKE_SHOT) {
                    frameScore = new FrameScore();
                    frameScore.setFirstScore(shot);
                    frameScore.setBonusPoint1(rawScores.get(i + 1));
                    frameScore.setBonusPoint2(rawScores.get(i + 2));
                    frameScores.add(frameScore);
                    break;
                }
                // if we this is a spare shot
                if(shot + rawScores.get(i + 1) == MAX_SHOT_COUNTS_IN_BOWLING) {
                    frameScore = new FrameScore();
                    frameScore.setFirstScore(shot);
                    frameScore.setSecondScore(rawScores.get(i + 1));
                    frameScore.setBonusPoint1(rawScores.get(i + 2));
                    frameScores.add(frameScore);
                    break;
                }
            }

            if(thisIsFirstShotOfFrame) {
                frameScore = new FrameScore();
                frameScore.setFirstScore(shot);
                thisIsFirstShotOfFrame = false;

                if(shot == SCORE_IN_STRIKE_SHOT) {
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
}
