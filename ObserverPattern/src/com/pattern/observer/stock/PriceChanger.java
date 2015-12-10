package com.pattern.observer.stock;

/**
 * Created by soyoon on 2015. 12. 9..
 */
public class PriceChanger extends Thread {
    private Stock stock;
    public PriceChanger(Stock stock) {
        super();
        this.stock = stock;
    }

    public void run() {
        try{
            while(true) {
                Thread.sleep(2000);
                int price = (int) (Math.random()*1000 + 50);
                int ran = (int) (Math.random() * 2);
                if(ran>0) {
                    stock.setPrice(stock.getPrice()+price);
                } else {
                    stock.setPrice(stock.getPrice()-price);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
