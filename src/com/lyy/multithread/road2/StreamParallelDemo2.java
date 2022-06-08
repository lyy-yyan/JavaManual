package com.lyy.multithread.road2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StreamParallelDemo2 {
    public static void main(String[] args) {
        System.out.println(String.format("本计算机的核数：%d", Runtime.getRuntime().availableProcessors()));

        // 产生100w个随机数(1 ~ 100)，组成列表
        Random random = new Random();
        List<Integer> list = new ArrayList<>(1000_0000);

        for (int i = 0; i < 1000_0000; i++) {
            list.add(random.nextInt(100));
        }

        long prevTime = getCurrentTime();
        list.stream().reduce((a, b) -> a + b).ifPresent(System.out::println);
        System.out.println(String.format("单线程计算耗时：%d ms", getCurrentTime() - prevTime));

        prevTime = getCurrentTime();
        list.stream().parallel().reduce((a, b) -> a + b).ifPresent(System.out::println);
        System.out.println(String.format("多线程计算耗时：%d ms", getCurrentTime() - prevTime));

        /*
        输出结果：
        本计算机的核数：16
        495179384
        单线程计算耗时：134 ms
        495179384
        多线程计算耗时：56 ms
         */
    }

    private static long getCurrentTime() {
        return System.currentTimeMillis();
    }
}
