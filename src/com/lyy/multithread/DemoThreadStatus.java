package com.lyy.multithread;

public class DemoThreadStatus {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        });
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
    }
}
