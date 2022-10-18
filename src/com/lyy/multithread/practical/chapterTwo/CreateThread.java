package com.lyy.multithread.practical.chapterTwo;

// 新建线程
// Java是单继承的，继承也是一种资源，因此最好使用Runnable接口实现新建线程
public class CreateThread implements Runnable {
    public static void main(String[] args) {
        // 继承方式新建线程
        Thread t1 = new Thread(() -> System.out.println("Hello, I am t1"));
        t1.start();
        Thread t2 = new Thread(new CreateThread());
        t2.start();
    }

    @Override
    public void run() {
        System.out.println("Hello, I am t2, use Runnable");
    }
}
