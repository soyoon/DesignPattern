package com.pattern.singleton.example;

/**
 * Created by soyoon on 2015. 12. 9..
 */
public class UserThread extends Thread {
    private Printer myPrinter;

    public UserThread(String name) {
        super(name);
    }

    public void run() {
        PrinterManager mgr = PrinterManager.getPrinterManager();
        myPrinter = mgr.getPrinter();
        myPrinter.print(getName());
    }
}
