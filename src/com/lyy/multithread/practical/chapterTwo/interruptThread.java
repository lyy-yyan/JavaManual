package com.lyy.multithread.practical.chapterTwo;

public class interruptThread {
    /*
    输出
    Interrupted when sleep
    Interrupted!
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Interrupted!");
                    break;
                }
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted when sleep");
                    /*
                     Thread.sleep()由于中断而抛出异常，
                     此时，它会清除中断标记，
                     如果不处理，那么下一次循环开始时，
                     就无法捕获这个中断，
                     所以在异常处理中，
                     需要再次设置中断标记位
                     */
                    Thread.currentThread().interrupt();
                }
                Thread.yield();
            }
        });
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
}
