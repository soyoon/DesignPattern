package com.pattern.composite;

/**
 * Created by soyoon on 2015. 12. 9..
 */
public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer();

        computer.addComponent(new KeyBoard(5, 10000));
        computer.addComponent(new Body(100, 900000));
        computer.addComponent(new Monitor(79, 100000));
        computer.addComponent(new Speaker(30, 15000));

        System.out.printf("소비전력 : %d\n", computer.getPower());
        System.out.printf("총 가격 : %d\n", computer.getPower());
    }
}
