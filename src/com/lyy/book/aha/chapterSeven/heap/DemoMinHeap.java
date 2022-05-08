package com.lyy.book.aha.chapterSeven.heap;

import java.util.Scanner;

/*
测试样例：
14
99 5 36 7 22 17 46 12 2 19 25 28 1 92
输出结果：
1 2 5 7 12 17 19 22 25 28 36 46 92 99
 */
// 最小堆以及堆排序
public class DemoMinHeap {
    public static void main(String[] args) {
        int[] heap = new int[51];
        // 读入要排序的数字个数
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for (int i = 1; i <= num; i++) {
            heap[i] = in.nextInt();
        }
        in.close();

        creatHeap(heap, num);

        for (int i = 1; i <= num; i++) {
            System.out.print(delTopHeap(heap, num) + " ");
        }
    }

    // 交换堆中编号x和y的两个元素的值
    public static void swap(int[] heap, int x, int y) {
        int t = heap[x];
        heap[x] = heap[y];
        heap[y] = t;
    }

    // 向下调整
    public static void siftdown(int[] heap, int n, int i) {
        boolean flag = false;   // 用来标记是否需要继续向下调整
        int t;  // 临时结点编号
        // 当i结点有儿子并且有需要继续调整的时候循环执行
        while (i*2 <= n && !flag) {
            // 首先判断i和左儿子的关系，并用t记录较小的结点编号
            if (heap[i] > heap[i*2]) {
                t = i*2;
            } else {
                t = i;
            }
            // 如果i有右儿子，再对右儿子进行讨论
            if (i*2+1 <= n) {
                // 用已记录的最小值与右儿子对比
                if (heap[t] > heap[i*2+1]) {
                    t = i*2+1;
                }
            }
            // 最小结点不是i自己
            if (i != t) {
                swap(heap, i, t);
                i = t;  // 更新当前i的编号
            } else {
                flag = true;    // 指不需要再调整
            }
        }
    }

    // 还可以向上调整
    public static void siftup(int[] heap, int n, int i) {
        boolean flag = false;
        if (i == 1) {
            return;
        }
        while (i != 1 && !flag) {
            if (heap[i] < heap[i/2]) {
                swap(heap, i, i/2);
            } else {
                flag = true;
            }
            i = i/2;
        }
    }

    // 建堆
    public static void creatHeap(int[] heap, int n) {
        // 从最后一个非叶子结点到第1个结点依次调整
        for (int i = n/2; i >= 1; i--) {
            siftdown(heap, n, i);
        }
    }

    // 删除堆顶元素
    public static int delTopHeap(int[] heap, int n) {
        int top = heap[1];
        heap[1] = heap[n];
        n --;
        siftdown(heap, n, 1);
        return top;
    }
}
