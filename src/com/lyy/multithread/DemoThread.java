package com.lyy.multithread;

import java.util.concurrent.*;

public class DemoThread {
    //继承Thread类
//    public static class MyThread extends Thread {
//        @Override
//        public void run() {
//            System.out.println("My Thread!");
//        }
//    }
//    public static void main(String[] args) {
//        Thread myThread = new MyThread();
//        myThread.start();
//    }

    //实现Runnable接口
//    public static class MyThread implements Runnable {
////        @Override
////        public void run() {
////            System.out.println("My Thread!");
////        }
////    }
////    public static void main(String[] args) {
////        new MyThread().run();
////
////        //函数式编程，以下内容可直接创建并运行一个线程
////        new Thread(() -> {
////            System.out.println("My Thread!");
////        }).start();
////    }

    //自定义Callable
    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            //模拟计算需要一秒
            Thread.sleep(1000);
            return 2;
        }

        //Future接口
//        public static void main(String[] args) throws ExecutionException, InterruptedException {
//            ExecutorService executor = Executors.newCachedThreadPool();
//            Task task = new Task();
//            Future<Integer> result = executor.submit(task);
//            //注意调用get方法回阻塞当前线程，直到得到结果
//            //实际编码中建议使用可以设置超时时间的重载get方法
//            System.out.println(result.get());
//        }

        //FutureTask类
        public static void main(String[] args) throws ExecutionException, InterruptedException {
            ExecutorService executor = Executors.newCachedThreadPool();
            FutureTask<Integer> futureTask = new FutureTask<>(new Task());
            executor.submit(futureTask);
            //此时submit方法没有返回值，实际上调用的是submit(Runnable task)方法，上面则调用的是submit(Callable<T> task)方法
            System.out.println(futureTask.get());
            //这里使用FutureTask直接get取值。而上面则是通过submit方法返回的Future去取值
        }
    }
}



