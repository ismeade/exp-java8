package com.ade.exp.java8.observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by liyang on 2017/3/14.
 */
public class Subject {

    private final List<Observer> observerList = new ArrayList<>();

    public void registerObserver(Observer observer) {
        this.observerList.add(observer);
    }

    public void notifyObserver(String message) {
        observerList.stream().parallel().forEach(observer -> observer.notify(message));
    }

}
