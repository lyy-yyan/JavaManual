package com.lyy.multithread.practical.chapterTwo;
/*
1666192239696:T1 start!
1666192239707:T1 wait for object
1666192239707:T2 start! notify one thread
1666192239707:T2 end!
1666192241710:T1 end!

注意时间戳信息，最后一条，T1在等待了两秒后才继续执行，因为T2还持有obj的锁
 */
public class SimpleWN {
    final static Object object = new Object();
    public static class T1 extends Thread{
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ":T1 start!");
                try {
                    System.out.println(System.currentTimeMillis() + ":T1 wait for object");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ":T1 end!");
            }
        }
    }

    public static class T2 extends Thread{
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ":T2 start! notify one thread");
                object.notify();
                System.out.println(System.currentTimeMillis() + ":T2 end!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        t2.start();
    }
}
