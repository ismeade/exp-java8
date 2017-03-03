package com.ade.exp.observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by liyang on 2017/3/2.
 */
public interface Subject {
    void registerObserver(Observer observer);
    void notifyObserver(String message);
}

class Feed implements Subject {

    private final List<Observer> observerList = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        this.observerList.add(observer);
    }

    @Override
    public void notifyObserver(String message) {
        observerList.stream().parallel().forEach(observer -> observer.notify(message));
    }
}