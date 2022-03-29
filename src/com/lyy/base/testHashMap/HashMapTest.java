package com.lyy.base.testHashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
HashMap 遍历从大的方向来说，可分为以下 4 类：
    1.迭代器（Iterator）方式遍历；
    2.For Each 方式遍历；
    3.Lambda 表达式遍历（JDK 1.8+）;
    4.Streams API 遍历（JDK 1.8+）。
但每种类型下又有不同的实现方式，因此具体的遍历方式又可以分为以下 7 种：
    1.使用迭代器（Iterator）EntrySet 的方式进行遍历；
    2.使用迭代器（Iterator）KeySet 的方式进行遍历；
    3.使用 For Each EntrySet 的方式进行遍历；
    4.使用 For Each KeySet 的方式进行遍历；
    5.使用 Lambda 表达式的方式进行遍历；
    6.使用 Streams API 单线程的方式进行遍历；
    7.使用 Streams API 多线程的方式进行遍历。
 */
public class HashMapTest {
    public static void main(String[] args) {
        //创建并赋值HashMap
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "SpringBoot");
        map.put(4, "MyBatis");
        map.put(5, "中文");

        //以下为各种遍历方法：
        System.out.println("===========================");
        //迭代器EntrySet
        Iterator<Map.Entry<Integer, String>> iterator1 = map.entrySet().iterator();
        while (iterator1.hasNext()) {
            Map.Entry<Integer, String> entry = iterator1.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        System.out.println("===========================");
        //迭代器KeySet
        Iterator<Integer> iterator2 = map.keySet().iterator();
        while (iterator2.hasNext()) {
            Integer key = iterator2.next();
            System.out.println(key);
            System.out.println(map.get(key));
        }

        System.out.println("===========================");
        //ForEach EntrySet
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        System.out.println("===========================");
        //ForEach KeySet
        for (Integer key : map.keySet()) {
            System.out.println(key);
            System.out.println(map.get(key));
        }

        System.out.println("===========================");
        //Lambda
        map.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
        });

        System.out.println("===========================");
        //Streams AP单线程
        map.entrySet().stream().forEach(integerStringEntry -> {
            System.out.println(integerStringEntry.getKey());
            System.out.println(integerStringEntry.getValue());
        });

        System.out.println("===========================");
        //Streams API多线程
        map.entrySet().parallelStream().forEach(integerStringEntry -> {
            System.out.println(integerStringEntry.getKey());
            System.out.println(integerStringEntry.getValue());
        });
    }
}
