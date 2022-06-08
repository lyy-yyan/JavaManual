package com.lyy.multithread.road2;

import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        long timeStart = System.currentTimeMillis();
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .reduce((a, b) -> {
                    System.out.println(String.format("%s: %d + %d = %d",
                            Thread.currentThread().getName(), a, b, a + b));
                    return a + b;
                })
                .ifPresent(System.out::println);
        long timeEnd = System.currentTimeMillis();
        System.out.println("运行时间：" + (timeEnd - timeStart) + "ms");
    }
}
/*
首先我们用整数1~9创建了一个Stream。
这里的Stream.of(T... values)方法是Stream接口的一个静态方法，
其底层调用的是Arrays.stream(T[] array)方法。
然后我们使用了reduce方法来计算这个集合的累加和。
reduce方法这里做的是：
从前两个元素开始，进行某种操作（我这里进行的是加法操作）后，
返回一个结果，然后再拿这个结果跟第三个元素执行同样的操作，
以此类推，直到最后的一个元素。
打印一下当前这个reduce操作的线程
以及它们被操作的元素和返回的结果
以及最后所有reduce方法的结果，
也就代表的是数字1到9的累加和。
 */
/*
输出打印：
main: 1 + 2 = 3
main: 3 + 3 = 6
main: 6 + 4 = 10
main: 10 + 5 = 15
main: 15 + 6 = 21
main: 21 + 7 = 28
main: 28 + 8 = 36
main: 36 + 9 = 45
45
运行时间：16ms
 */