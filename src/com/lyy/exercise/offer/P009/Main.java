package com.lyy.exercise.offer.P009;

public class Main {
    public static void main(String[] args) {
        /*
        输入：
        ["CQueue","appendTail","deleteHead","deleteHead"]
        [[],[3],[],[]]
        输出：[null,null,3,-1]
         */
        System.out.println("样例1");
        CQueue cQueue1 = new CQueue();
        cQueue1.appendTail(3);
        System.out.println(cQueue1.deleteHead());
        System.out.println(cQueue1.deleteHead());

        /*
        输入：
        ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
        [[],[],[5],[2],[],[]]
        输出：[null,-1,null,null,5,2]
         */
        System.out.println("样例2");
        CQueue cQueue2 = new CQueue();
        System.out.println(cQueue2.deleteHead());
        cQueue2.appendTail(5);
        cQueue2.appendTail(2);
        System.out.println(cQueue2.deleteHead());
        System.out.println(cQueue2.deleteHead());
    }
}
