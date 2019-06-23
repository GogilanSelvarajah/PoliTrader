package com.example.politrader;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

class Politician implements Serializable {
    ArrayList<String> scores;
    String name;

    Politician(String name, ArrayList<String> scores) {
        this.name = name;
        this.scores = scores;
    }

    String getName() {
        return this.name;
    }

    String getCurrentScore() {
        return scores.get(scores.size()-1);
    }

    Double getChange() {
        if (scores.size() == 1) {
            return 1.0;
        }

        else {
            Double lastScore = Double.parseDouble(scores.get(scores.size()-2));
            Double currentScore = Double.parseDouble(getCurrentScore());

            DecimalFormat df = new DecimalFormat("##.00");
            return Double.parseDouble(df.format(currentScore - lastScore));
        }
    }
}

