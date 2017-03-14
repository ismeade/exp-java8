package com.ade.exp.java8.observer;

import com.ade.exp.java8.observer.impl.Guardian;
import com.ade.exp.java8.observer.impl.LeMonde;
import com.ade.exp.java8.observer.impl.NYTimes;

/**
 *
 * Created by liyang on 2017/3/14.
 */
public class ObserverMain {

    public static void main(String[] args) {

        Subject subject = new Subject();
        subject.registerObserver(new NYTimes());
        subject.registerObserver(new Guardian());
        subject.registerObserver(new LeMonde());

        subject.notifyObserver("The queen said her favourite book is Java 8 in Action. money");
    }

}
