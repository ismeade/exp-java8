package com.ade.exp.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

/**
 *
 * Created by liyang on 2017/2/21.
 */
public class UsefulExp {

    public static void main(String[] args) {
        // 布尔表达式
        Predicate<List<String>> predicate = (List<String> list) -> list.isEmpty();
        // Predicate<List<String>> predicate = list -> list.isEmpty();
        // Predicate<List<String>> predicate = List<String>::isEmpty;
        // Predicate<List<String>> predicate = List::isEmpty;

        // 创建对象
        Supplier<List<String>> supplier = () -> new ArrayList<>();
        // Supplier<List<String>> supplier = ArrayList::new;

        // 消费一个对象
        Consumer<String> consumer = (String s) -> System.out.println(s);
        // Consumer<String> consumer = (s) -> System.out.println(s);
        // Consumer<String> consumer = System.out::println;

        // 从一个对象中提取
        Function<String, Integer> function = (String s) -> s.length();
        // Function<String, Integer> function = (s) -> s.length();
        // Function<String, Integer> function = String::length;
        ToIntFunction<String> toIntFunction = (String s) -> s.length();
        // ToIntFunction<String> toIntFunction = String::length;
        // ...

        // 合并两个值
        IntBinaryOperator intBinaryOperator = (int a, int b) -> a * b;
        // IntBinaryOperator intBinaryOperator = (a, b) -> a * b;

        // 比较两个对象
        Comparator<String> comparator = (String a, String b) -> new Integer(a.length()).compareTo(b.length());
        // Comparator<String> comparator = (a, b) -> new Integer(a.length()).compareTo(b.length());

    }

}
