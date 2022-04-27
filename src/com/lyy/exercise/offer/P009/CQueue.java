package exercise.leetcode.offer.P009;

import java.util.Stack;

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */

public class CQueue {

    //双栈实现队列
    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    public CQueue() {
        this.inputStack  = new Stack<Integer>();
        this.outputStack  = new Stack<Integer>();
    }

    //队列插入元素即推入插入栈即可
    public void appendTail(int value) {
        inputStack.push(value);
    }

    public int deleteHead() {
        //如果插入栈和输出栈都为空，则队列为空
        if (outputStack.isEmpty() && inputStack.isEmpty()) {
            return -1;
        }
        //如果输出栈为空，则将插入栈的元素都推入输出栈
        //如果输出栈不为空，则弹出一个元素，即为队列的头元素
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
            return outputStack.pop();
        }else {
            return outputStack.pop();
        }
    }
}

/*
inputStack 123 in456
outputStack 321 out1 out23 in654
queue in123 out12 in456 out3456
 */
