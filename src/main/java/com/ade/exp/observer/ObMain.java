package com.ade.exp.observer;

/**
 *
 * Created by liyang on 2017/3/2.
 */
public class ObMain {

    public static void main(String[] args) {
        Subject subject = new Feed();
        subject.registerObserver(new NYTimes());
        subject.registerObserver(new Guardian());
        subject.registerObserver(new LeMonde());

        subject.notifyObserver("The queen said her favourite book is Java 8 in Action. money");
    }

}
