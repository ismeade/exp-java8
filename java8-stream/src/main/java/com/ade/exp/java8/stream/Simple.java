package com.ade.exp.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 *
 * Created by liyang on 2017/3/2.
 */
public class Simple {


    private Simple() {}

    public void test1() {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 1; i <= 10000000; i++) {
            numberList.add(i);
        }
        long start = System.currentTimeMillis();
        numberList.stream().filter((Integer i) -> i % 2 == 0).anyMatch(i -> i % 1000000 == 0);
//        numberList.stream().filter((Integer i) -> i % 2 == 0).collect(Collectors.toList());
//        numberList.parallelStream().filter((Integer i) -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(System.currentTimeMillis() - start);

    }

    public void test2() {
        long start = System.currentTimeMillis();
        Stream.iterate(0, i -> i++).filter((Integer i) -> i % 2 == 0).anyMatch(i -> i == 1000000);
        System.out.println(System.currentTimeMillis() - start);
    }

    private long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }

    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n).parallel().reduce(0L, Long::sum);
    }

    public void test3() {
        System.out.println("Sequential sum done in: " + measureSumPerf(Simple::rangedSum, 10_000_000) + " msecs");
    }

    public static void main(String[] args) {
        new Simple().test3();
    }

}
