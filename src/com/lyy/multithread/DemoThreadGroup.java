package com.lyy.multithread;

public class DemoThreadGroup {
    public static void main(String[] args) {
        ThreadGroup threadGroup1 = new ThreadGroup("group1") {
          /*
          继承ThreadGroup并重新定义一下方法
          在线程成员抛出unchecked exception
          会执行此方法
           */
          public void uncaughtException(Thread thread, Throwable throwable) {
              System.out.println(thread.getName() + ":" + throwable.getMessage());
          }
        };

        //这个线程是threadGroup1的一员
        Thread thread1 = new Thread(threadGroup1, new Runnable() {
            @Override
            public void run() {
                //抛出unchecked异常
                throw new RuntimeException("测试异常");
            }
        });

        thread1.start();
    }
}
