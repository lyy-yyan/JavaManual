# 剑指 Offer 09. 用两个栈实现队列
## 题目描述
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。<br />
(若队列中没有元素，deleteHead 操作返回 -1 )<br />

来源：力扣（LeetCode）<br />
链接：https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof <br />
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。<br />
## 题目要求
- 1 <= values <= 10000 
- 最多会对 appendTail、deleteHead 进行 10000 次调用
## 测试样例
输入：<br />
["CQueue","appendTail","deleteHead","deleteHead"] <br />
[[],[3],[],[]] <br />
输出：[null,null,3,-1] <br />

输入：<br />
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"] <br />
[[],[],[5],[2],[],[]] <br />
输出：[null,-1,null,null,5,2] <br />
# 官方题解
```java
class CQueue {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public CQueue() {
        inStack = new ArrayDeque<Integer>();
        outStack = new ArrayDeque<Integer>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if (outStack.isEmpty()) {
            if (inStack.isEmpty()) {
                return -1;
            }
            in2out();
        }
        return outStack.pop();
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
```