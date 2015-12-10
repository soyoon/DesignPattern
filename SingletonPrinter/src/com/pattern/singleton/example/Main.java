package com.pattern.singleton.example;

/**
 * Created by soyoon on 2015. 12. 9..
 */
public class Main {
    private static final int THREAD_NUM = 10;
    public static void main(String[] args) {
        UserThread[] user = new UserThread[THREAD_NUM];
        for (int i=0; i<THREAD_NUM; i++) {
            user[i] = new UserThread((i+1) + "-thread");
            user[i].start();
        }
    }

}
