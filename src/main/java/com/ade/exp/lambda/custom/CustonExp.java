package com.ade.exp.lambda.custom;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 *
 * Created by liyang on 2017/2/21.
 */
public class CustonExp {

    private static void show(Book book) {
        System.out.println(book.show());
    }

    private static void startServer(Server server, String name) {
        server.start(name);
    }

    private static void println(String value) {
        System.out.println(value);
    }

    public static void main(String[] args) {

        show(() -> "book1");
        show(() -> "book1");

        Server s1 = name -> System.out.println("1 " + name);

        Server s2 = name -> {println("2 " + name); println("2 " + name);};

        s1.start("abc");
        s2.start("abc");
        startServer(name -> System.out.println("3 " + name), "abc");


        Function<Object, String> function = Object::toString;
        System.out.println(function.apply(1));


    }

}
