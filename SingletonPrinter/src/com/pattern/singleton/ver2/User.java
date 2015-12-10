package com.pattern.singleton.ver2;

/**
 * Created by soyoon on 2015. 12. 9..
 */
public class User extends Thread {
    private String name;
    private long time;

    public User(String name, long time) {
        super();
        this.name = name;
        this.time = time;
    }

    public void run() {
        usePrint();
    }

    public void usePrint() {
        Printer.print(String.format("%s user is using...", name), time);
    }
}
