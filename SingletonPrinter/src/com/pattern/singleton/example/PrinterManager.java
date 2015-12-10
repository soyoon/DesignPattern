package com.pattern.singleton.example;

import java.util.ArrayList;

/**
 * Created by soyoon on 2015. 12. 9..
 */
public class PrinterManager {
    public static PrinterManager mgr;
    private ArrayList<Printer> printers = new ArrayList<>();
    private PrinterManager() {
    }

    // 놓쳤다...

    public synchronized static PrinterManager getPrinterManager() {
        if(mgr == null) {
            mgr = new PrinterManager();

        }
        return mgr;
    }

//    public static PrinterManager getPrinterManager() {
//        synchronized (PrinterManager.class) { // 얘가 static method이기 때문에 synchronized(this) 안됨.
//            if(instance == null) {
//                try{Thread.sleep(1);}catch (Exception e){}
//                instance = new PrinterManager();
//            }
//        }
//        return instance;
//    }

    public Printer getPrinter() {
        while(true) {
            for (Printer printer: printers) {
                synchronized(printer) {
                    if(printer.isAvailable()) {
                        printer.setAvailable(false);
                        return printer;
                    }
                }
            }
        }
    }

}
