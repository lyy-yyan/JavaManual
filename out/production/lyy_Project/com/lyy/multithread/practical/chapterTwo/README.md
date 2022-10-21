# Java并行程序基础
## 线程状态
```java
// 线程的所有状态都在Thread中的State枚举中定义
public enum State {
    NEW,
    RUNNABLE,
    BLOCKED,    // 阻塞状态
    WAITING,
    TIMED_WAITING,
    TERMINATED
}
```
状态转换说明：
- NEW -(start启动)-> RUNNABLE -(结束)-> TERMINATED
- BLOCKED <-(同步块synchronized)-> RUNNABLE
- RUNNABLE -(wait等待)-> WAITING, WAITING -(notify通知)-> RUNNABLE
- RUNNABLE -(wait等待)-> TIMED_WAITING, TIMED_WAITING -(notify通知)-> RUNNABLE

> 通过wait()方法等待的线程在等待notify()方法，而通过join()方法等待的线程则会等待目标线程的终止。
## 基本操作
- 新建线程
  - CreateThread.java
- 终止线程，可以使用stop()，但是不建议使用，可以自己写一个停止线程的方法
  - StopThreadSafe.java
  - StopThreadUnsafe.java
- 中断线程 .interrupt()[设置中断标志位]，指JDK提供的，告知目标线程，希望退出，至于目标线程接到通知后如何处理，由目标线程决定，而不是无条件退出
- 等待 .wait()，当对象实例调用后，当前线程就会在这个对象上等待直到其他线程调用 obj.notify()方法为止
  - 执行 obj 的 wait() 方法前，必须先获得 obj 的监视器，wait()执行后会释放这个监视器
- 通知 .notify()，通知后会从等待队列随机选取一个线程唤醒（不公平的）
  - 线程被唤醒后，还要再次重新获得 obj 的监视器（再执行wait()方法执行前所持有的那个），顺利获得后才能继续执行
  - SimpleWN.java
  - wait()和 sleep()方法都可以让线程等待，除了 wait()可以被唤醒外，另一个主要区别是 wait()会释放目标对象的锁，而 sleep()不会释放任何资源