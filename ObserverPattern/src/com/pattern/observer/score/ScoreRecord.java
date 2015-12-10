package com.pattern.observer.score;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by soyoon on 2015. 12. 9..
 */
public class ScoreRecord extends Subject {

    private List<Integer> scores = new ArrayList<>(10);

    public void addScore(int score) {
        scores.add(score);
        notifyObservers();
    }

    public List<Integer> getScoreRecord() {
        return scores;
    }
}
