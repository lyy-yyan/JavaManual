> 所有代码部分请见文件Practice.java
# Java并行程序基础
## 线程状态
```java
// 线程的所有状态都在Thread中的Statr枚举中定义
public enum State {
    NEW,
    RUNNABLE,
    BLOCKED,    // 阻塞状态
    WAITING,
    TIMED_WAITING,
    TERMINATED;
}
```
状态转换说明：
- NEW -(start启动)-> RUNNABLE -(结束)-> TERMINATED
- BLOCKED <-(同步块synchronized)-> RUNNABLE
- RUNNABLE -(wait等待)-> WAITING, WAITING -(notify通知)-> RUNNABLE
- RUNNABLE -(wait等待)-> TIMED_WAITING, TIMED_WAITING -(notify通知)-> RUNNABLE

> 通过wait()方法等待的线程在等待notify()方法，而通过join()方法等待的线程则会等待目标线程的终止。
## 基本操作
- 新建线程（见代码）
- 终止线程，可以使用stop()，但是不建议使用
