package com.pattern.composite;

/**
 * Created by soyoon on 2015. 12. 9..
 */
public class Body implements ComputerDevice {
    private int power;
    private int price;

    public Body(int power, int price) {
        this.power = power;
        this.price = price;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public int getPower() {
        return 0;
    }
}
