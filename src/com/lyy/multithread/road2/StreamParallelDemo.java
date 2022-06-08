package com.lyy.multithread.road2;

import java.util.stream.Stream;

public class StreamParallelDemo {
    public static void main(String[] args) {
        long timeStart = System.currentTimeMillis();
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .parallel() // 与StreamDemo相比增加一行代码，使Stream使用多线程来并行计算
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
可以很明显地看到，
它使用的线程是ForkJoinPool里面的
commonPool里面的worker线程。
并且它们是并行计算的，
并不是串行计算的。
但由于Fork/Join框架的作用，
它最终能很好的协调计算结果，
使得计算结果完全正确。

 */
/*
输出打印：
ForkJoinPool.commonPool-worker-3: 1 + 2 = 3
main: 5 + 6 = 11
ForkJoinPool.commonPool-worker-2: 8 + 9 = 17
ForkJoinPool.commonPool-worker-1: 3 + 4 = 7
ForkJoinPool.commonPool-worker-1: 3 + 7 = 10
ForkJoinPool.commonPool-worker-2: 7 + 17 = 24
ForkJoinPool.commonPool-worker-2: 11 + 24 = 35
ForkJoinPool.commonPool-worker-2: 10 + 35 = 45
45
运行时间：25ms
 */
// 虽然使用了多线程会变快，但是针对简单的问题，这反而变复杂了，因为切换线程需要成本
// 但是如果是针对每一步都能执行一段时间的问题来说，多线程执行会更好