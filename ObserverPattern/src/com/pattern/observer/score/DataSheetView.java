package com.pattern.observer.score;

import java.util.Collections;
import java.util.List;

/**
 * Created by soyoon on 2015. 12. 9..
 */
public class DataSheetView implements Observer{
    private ScoreRecord record;
    private int viewCount;

    public DataSheetView(ScoreRecord record, int viewCount) {
        this.record = record;
        this.viewCount = viewCount;

    }

    public void update() {
        List<Integer> stores = record.getScoreRecord();
        displayScore(stores);
    }
    private void displayScore(List<Integer> scores) {
        if(scores!=null) {
            int size = viewCount;
            if(scores.size()<viewCount) {
                size = scores.size();
            }
            for(int i=0; i< size; i++) {
                System.out.println(scores.get(i));
            }
        }
    }
}
