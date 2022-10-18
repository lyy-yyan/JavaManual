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
- 新建线程（CreateThread.java）
- 终止线程，可以使用stop()，但是不建议使用，可以自己写一个停止线程的方法
- 中断线程，指JDK提供的，告知目标线程，希望退出，至于目标线程接到通知后如何处理，由目标线程决定，而不是无条件退出
- 
