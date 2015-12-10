package com.pattern.observer.score;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by soyoon on 2015. 12. 9..
 */
public abstract class Subject {
    private List<Observer> observers = new ArrayList<>(3);
    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update();
        }

    }
}
