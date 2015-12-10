package com.pattern.composite;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by soyoon on 2015. 12. 9..
 */
public class Computer implements ComputerDevice {

    private List<ComputerDevice> container = new LinkedList<ComputerDevice>();

    public void addComponent(ComputerDevice device) {
        container.add(device);
    }
    public void removeComponent(ComputerDevice device) {
        container.remove(device);
    }

    @Override
    public int getPrice() {
        int price = 0;
        for(ComputerDevice device : container) {
            price += device.getPrice();
        }
        return price;
    }

    @Override
    public int getPower() {
        int power = 0;
        for(ComputerDevice device : container) {
            power += device.getPower();
        }

        return power;
    }
}
