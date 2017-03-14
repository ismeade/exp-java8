package com.ade.exp.java8.observer;

/**
 *
 * Created by liyang on 2017/3/14.
 */
public class NewMain {

    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.registerObserver(message -> {
            if (message != null && message.contains("queen")) System.out.println("Yet another news in London... " + message);
        });
        subject.registerObserver(message -> {
            if (message != null && message.contains("wine")) System.out.println("Yet another news in London... " + message);
        });
        subject.registerObserver(message -> {
            if (message != null && message.contains("money")) System.out.println("Yet another news in London... " + message);
        });

        subject.notifyObserver("The queen said her favourite book is Java 8 in Action.");
    }

}
