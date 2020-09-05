package com.mercell.bowling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreFileReader {

    private String filePath;

    public ScoreFileReader(String filePath) {
        this.filePath = filePath;
    }

    /**
     * This method reads a single-line file and creates a list of scores
     * @return List<Integer>
     */
    public List<Integer> readFileAndExtractTheScores() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line = br.readLine();
        List<String> scoresAsStringList = Arrays.asList(line.replaceAll("\\s+","").split(","));
        return scoresAsStringList.stream().map(Integer::parseInt).collect(Collectors.toList());

    }

}
