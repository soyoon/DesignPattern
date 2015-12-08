package com.pattern.singleton.ver1;

/**
 * Created by soyoon on 2015. 12. 8..
 */
public class Main {
    public static void main(String[] args) {
        User[] users = new User[5];
        for(int i=0; i< users.length; i++) {
            users[i] = new User(i+"-");
            users[i].start();
        }
    }
}
