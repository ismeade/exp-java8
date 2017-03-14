package com.ade.exp.java8.observer.impl;

import com.ade.exp.java8.observer.Observer;

/**
 *
 * Created by liyang on 2017/3/14.
 */
public class NYTimes implements Observer {

    @Override
    public void notify(String message) {
        if (message != null && message.contains("money")) {
            System.out.println("Breaking news in NY! " + message);
        }
    }

}
