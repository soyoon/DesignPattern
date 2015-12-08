package com.pattern.singleton.ver1;

/**
 * Created by soyoon on 2015. 12. 8..
 */
public class User extends Thread {
    private String name;

    public User(String name) {
        super();
        this.name = name;
    }

    public void run() {
        usePrint();
    }

    public void usePrint() {
        Printer printer = Printer.getInstance();
        printer.print(String.format("%s user is using...", name));
    }
}
