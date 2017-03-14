package com.ade.exp.java8.optional;

import java.util.Optional;

/**
 *
 * Created by liyang on 2017/3/3.
 */
public class Simple {

    public static Optional<Integer> stringToInteger(String value) {
        try {
            return Optional.of(Integer.parseInt(value));
        } catch (NumberFormatException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        System.out.println(stringToInteger("a").orElse(0));
        stringToInteger("2").ifPresent(System.out::println);
        System.out.println(stringToInteger("-1").get());
    }

}
