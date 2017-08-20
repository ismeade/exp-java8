package com.ade.exp.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liyang on 17-8-20.
 */
public class ReduceSimple {

    private List<String> list = Arrays.asList("a", "bb", "ccc", "ddd");

    /**
     *  这个方法只为了演示了reduce三个参数的使用方法，过程其实可以用相对简单的方法实现(如map)
     *  实际中很少使用到reduce
     */
    private void test1() {
        List<String> test = list.stream().reduce(new ArrayList<>(), // 参数1 初始值，也是最后的返回值，比如一个空集合
                (strings, s) -> { // 第一个参数是之前定义的初始值，第二参数是stream中元素，之后要返回
                    strings.add("Bi " + s);
                    return strings;
                },
                (strings1, strings2) -> { // 通过Join/Fork拆分的任务怎么组合到一起 上边操作的集合 最后两两做的操作
                    strings1.addAll(strings2);
                    return strings1;
                }
        );
        System.out.println(test);
    }

    public static void main(String[] args) {
        new ReduceSimple().test1();
    }

}
