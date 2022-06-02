package com.lyy.multithread.road2;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/*
为什么在这里普通的递归或循环效率更快呢？
因为Fork/Join是使用多个线程协作来计算的
所以会有线程通信和线程切换的开销。
如果要计算的任务比较简单（比如我们案例中的斐波那契数列）
那当然是直接使用单线程会更快一些
但如果要计算的东西比较复杂
计算机又是多核的情况下
就可以充分利用多核CPU来提高计算速度
 */
public class FibonacciTest {
    // 用一个计算斐波那契数列第n项的例子来看一下Fork/Join的使用
    static class Fibonacci extends RecursiveTask<Integer> {

        int n;

        public Fibonacci(int n) {
            this.n = n;
        }

        // 主要的实现逻辑都在compute()里
        @Override
        protected Integer compute() {
            // 这里先假设 n >= 0
            if (n <= 1) {
                return n;
            } else {
                // f(n-1)
                Fibonacci f1 = new Fibonacci(n - 1);
                f1.fork();
                // f(n-2)
                Fibonacci f2 = new Fibonacci(n - 2);
                f2.fork();
                // f(n) = f(n-1) + f(n-2)
                return f1.join() + f2.join();
            }
        }
    }

    @Test
    public void testFib() throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        System.out.println("CPU核数:" + Runtime.getRuntime().availableProcessors());
        long start = System.currentTimeMillis();
        Fibonacci fibonacci = new Fibonacci(40);
        /*
        Future 表示异步计算的结果
        提供了检查计算是否完成、等待其完成以及检索计算结果的方法
        结果只能在计算完成后使用方法 get 检索，必要时阻塞，直到它准备好
         */
        Future<Integer> future = forkJoinPool.submit(fibonacci);
        System.out.println("计算结果:" + future.get());
        long end = System.currentTimeMillis();
        System.out.format("耗时:%d millis\n", end - start);
        /*
        CPU核数:16
        计算结果:102334155
        耗时:1690 millis
         */
    }

    // 普通递归，复杂度为O(2^n)
    public int plainRecursion(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return plainRecursion(n -1) + plainRecursion(n - 2);
        }
    }

    @Test
    public void testPlain() {
        long start = System.currentTimeMillis();
        int result = plainRecursion(40);
        long end = System.currentTimeMillis();
        System.out.println("计算结果:" + result);
        System.out.format("耗时:%d millis\n",  end -start);
        /*
        计算结果:102334155
        耗时:227 millis
         */
    }

    // 通过循环来计算，复杂度为O(n)
    private int computeFibonacci(int n) {
        // 假设n >= 0
        if (n <= 1) {
            return n;
        } else {
            int first = 1;
            int second = 1;
            int third = 0;
            for (int i = 3; i <= n; i ++) {
                // 第三个数是前两个数之和
                third = first + second;
                // 前两个数右移
                first = second;
                second = third;
            }
            return third;
        }
    }

    @Test
    public void testComputeFibonacci() {
        long start = System.currentTimeMillis();
        int result = computeFibonacci(40);
        long end = System.currentTimeMillis();
        System.out.println("计算结果:" + result);
        System.out.format("耗时:%d millis\n",  end -start);
        /*
        计算结果:102334155
        耗时:0 millis
         */
    }
}
