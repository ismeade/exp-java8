package com.ade.exp.java8.stream;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liyang on 17-8-20.
 */
public class MapForEachSimple {

    private Map<String, Object> map = new HashMap<>();

    private MapForEachSimple() {
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        map.put("e", 5);

    }

    private void test1() {
        map.forEach((s, o) -> System.out.println(s + " " + o));
    }

    public static void main(String[] args) {
        new MapForEachSimple().test1();
    }

}
