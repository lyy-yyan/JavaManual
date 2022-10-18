package com.lyy.multithread.practical.chapterTwo;

public class StopThreadSafe {
    public static User u = new User();
    public static class User {
        private int id;
        private String name;
        public User() {
            id = 0;
            name = "0";
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static class ChangeObjectThread extends Thread {
        // 用于指示线程是否需要退出的标志
        volatile boolean stopMe = false;
        public void stopMe() {
            stopMe = true;
        }
        @Override
        public void run() {
            while (true) {
                if (stopMe) {
                    System.out.println("exit by stop me");
                    break;
                }
                synchronized (u) {
                    int v = (int)(System.currentTimeMillis()/1000);
                    u.setId(v);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    u.setName(String.valueOf(v));
                }
                Thread.yield();
            }
        }
    }

    public static class ReadObjectThread extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (u) {
                    // 如果读到id和name不一样则输出
                    if (u.getId() != Integer.parseInt(u.getName())) {
                        System.out.println(u.toString());
                    }
                }
            }
        }
    }

    // 运行下面程序，可以看到，不会再输出数据不一致的情况
    public static void main(String[] args) throws InterruptedException {
        new ReadObjectThread().start();
        while (true) {
            ChangeObjectThread changeThread = new ChangeObjectThread();
            changeThread.start();;
            Thread.sleep(150);
            changeThread.stopMe();
        }
    }
}
