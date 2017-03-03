package com.ade.exp.observer;

/**
 *
 * Created by liyang on 2017/3/2.
 */
public interface Observer {

    void notify(String message);



}

class NYTimes implements Observer {
    @Override
    public void notify(String message) {
        if (message != null && message.contains("money")) {
            System.out.println("Breaking news in NY! " + message);
        }
    }
}

class Guardian implements Observer {
    @Override
    public void notify(String message) {
        if (message != null && message.contains("queen")) {
            System.out.println("Yet another news in London... " + message);
        }
    }
}

class LeMonde implements Observer {
    @Override
    public void notify(String message) {
        if (message != null && message.contains("wine")) {
            System.out.println("Today cheese, wine and news! " + message);
        }
    }
}
