package com.pattern.observer.score;

import java.util.Collections;
import java.util.List;

/**
 * Created by soyoon on 2015. 12. 9..
 */
public class MinMaxView implements Observer {
    private ScoreRecord record;
    public MinMaxView(ScoreRecord record) {
        this.record = record;
    }
    @Override
    public void update() {
        List<Integer> scores = record.getScoreRecord();
        displayMinMax(scores);
    }
    private void displayMinMax(List<Integer> scores) {
        int min = Collections.min(scores, null);
        int max = Collections.max(scores, null);
        System.out.printf("min : %d max : %d \n", min, max);
    }
}
