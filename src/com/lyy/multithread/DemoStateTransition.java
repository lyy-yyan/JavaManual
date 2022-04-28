package com.lyy.multithread;

import org.junit.Test;

public class DemoStateTransition {
    @Test
    public void blockedTest() throws InterruptedException {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "a");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "b");

        a.start();
//        a.join();// 此时打印结果 a:TERMINATED b:TIMED_WAITING
        a.join(1000L);// 此时打印结果 a:TIMED_WAITING b:BLOCKED
        /*
        若main线程不休眠，打印结果为：
        a:RUNNABLE
        b:BLOCKED
        main休眠后，打印结果为：
        a:TIMED_WAITING
        b:BLOCKED
         */
//        Thread.sleep(1000L);
        b.start();
        System.out.println(a.getName() + ":" + a.getState());
        System.out.println(b.getName() + ":" + b.getState());
    }


    // 同步方法争夺锁
    private synchronized void testMethod() {
        // 当Synchronized关键字用于类方法定义中时
        // 表示所有调用该方法的线程都必须获得当前对象的锁
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
