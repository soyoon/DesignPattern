package com.pattern.observer.stock;

import java.util.Observable;

/**
 * Created by soyoon on 2015. 12. 9..
 */
public class Stock extends Observable {
    private String ticker;
    private String name;
    private double price;

    public Stock(String ticker, String name, double price) {
        this.ticker = ticker;
        this.name = name;
        this.price = price;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws Exception {
        if(price>=0) {
            this.price = price;
            setChanged();
            notifyObservers();
        }else {
            throw new Exception("Invalid Price");
        }
    }
}
