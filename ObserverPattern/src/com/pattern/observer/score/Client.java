package com.pattern.observer.score;

/**
 * Created by soyoon on 2015. 12. 9..
 */
public class Client {

    public static void main(String[] args) {
        ScoreRecord record = new ScoreRecord();
        DataSheetView view1 = new DataSheetView(record, 5);
        DataSheetView view2 = new DataSheetView(record, 3);
        MinMaxView view3 = new MinMaxView(record);

        record.attach(view1);
        record.attach(view2);
        record.attach(view3);

        for(int i=0; i<10; i++) {
            int score = (int) (Math.random()*101);
            System.out.printf("score :%d\n", score);
            record.addScore(score);
        }
    }
}

