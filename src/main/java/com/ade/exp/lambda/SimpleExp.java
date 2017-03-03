package com.ade.exp.lambda;

/**
 *
 * Created by liyang on 2017/2/21.
 */
public class SimpleExp {

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World 1");
            }
        };

        Runnable r2 = () -> System.out.println("Hello World 2");

        new Thread(r1).start();
        new Thread(r2).start();
        new Thread(() -> System.out.println("Hello World 3")).start();

    }

}
