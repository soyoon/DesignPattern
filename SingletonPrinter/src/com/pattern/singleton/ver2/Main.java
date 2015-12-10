package com.pattern.singleton.ver2;

/**
 * Created by soyoon on 2015. 12. 9..
 */
public class Main {
    public static void main(String[] args) {
        User[] users = new User[5];
        long time = System.currentTimeMillis();
        for(int i=0; i< users.length; i++) {
            users[i] = new User(i+"-", time);
            users[i].start();
        }
    }
}
