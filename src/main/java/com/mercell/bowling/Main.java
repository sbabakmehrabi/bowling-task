package com.mercell.bowling;

import java.io.IOException;
import java.util.List;

public class Main {


    public static void main(String[] argc) {

        if(argc.length == 0) {
            System.out.println("You must specify the file path of game score");
            return;
        }

        ScoreFileReader scoreFileReader = new ScoreFileReader(argc[0]);
        try {
            // Reading the file and extract raw numbers
            List<Integer> rawScores = scoreFileReader.readFileAndExtractTheScores();

            // convert raw numbers to a list of frame scores
            SequenceToFrameScoreConverter sequenceToFrameScoreConverter = new SequenceToFrameScoreConverter();
            List<FrameScore> frameScores = sequenceToFrameScoreConverter.convert(rawScores);

            // calculate the total game score and print the score table to stdout
            GameResultPrinter gameResultPrinter = new GameResultPrinter(frameScores);
            gameResultPrinter.print();

        } catch (IOException e) {
            System.out.println("The provided file was not found");
        }


    }
}
