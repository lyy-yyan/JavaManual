package com.lyy.book.aha.chapterEight.prim;

import java.util.Scanner;

/*
最小生成树
测试样例：
6 9
2 4 11
3 5 13
4 6 3
5 6 4
2 3 6
4 5 7
1 2 1
3 4 9
1 3 2
输出结果：
19
 */
// Prim算法堆优化，邻接表存储，堆方法寻找最小dis
public class DemoMinSpanningTreeOptimization {
    public static final int MAX = 99999999;       // 不可修改的最大值，表无穷
    // 邻接表存储图
    public static int[] u = new int[19];
    public static int[] v = new int[19];
    public static int[] w = new int[19];
    public static int[] first = new int[7];
    public static int[] next = new int[19];

    public static int[] dis = new int[7];         // 用以存储各个顶点到树的最小距离
    public static int[] book = new int[7];        // 用以记录该顶点是否在树内

    // h用以存储堆，pos用以存储每个顶点在堆中的位置，size为堆的大小
    public static int[] h = new int[7];
    public static int[] pos = new int[7];
    public static int size = 0;

    public static int count = 0;                  // 用以记录生成树中顶点的个数
    public static int sum = 0;                    // 用以存储生成树路径之和

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nodeNum = in.nextInt();
        int edgeNum = in.nextInt();
        // 读入边
        for (int i = 1; i <= edgeNum; i++) {
            u[i] = in.nextInt();
            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }
        // 无向图存储
        for (int i = edgeNum + 1; i <= 2 * edgeNum; i++) {
            u[i] = v[i-edgeNum];
            v[i] = u[i-edgeNum];
            w[i] = w[i-edgeNum];
        }
        // 邻接表存储边
        // 初始化first数组
        for (int i = 1; i <= nodeNum; i++) {
            first[i] = -1;
        }
        for (int i = 1; i <= 2 * edgeNum; i++) {
            next[i] = first[u[i]];
            first[u[i]] = i;
        }

        // Prim核心部分
        book[1] = 1;
        count ++;

        // 初始化dis数组
        dis[1] = 0;
        for (int i = 2; i <= nodeNum; i++) {
            dis[i] = MAX;
        }
        int k = first[1];
        while (k != -1) {
            dis[v[k]] = w[k];
            k = next[k];
        }

        // 初始化堆
        size = nodeNum;
        for (int i = 1; i <= size; i++) {
            h[i] = i;
            pos[i] = i;
        }
        for (int i = size / 2; i >= 1; i--) {
            siftdown(i);
        }
        popH();     // 此时堆顶是1号顶点，需先弹出

        while (count < nodeNum) {
            int j = popH();
            book[j] = 1;
            count ++;
            sum += dis[j];

            k = first[j];
            while (k != -1) {
                if (book[v[k]] == 0 && dis[v[k]] > w[k]) {
                    dis[v[k]] = w[k];
                    siftup(pos[v[k]]);
                }
                k = next[k];
            }
        }
        System.out.println(sum);
    }

    // 交换堆中两个元素的值
    public static void swap(int x, int y) {
        int t = h[x];
        h[x] = h[y];
        h[y] = t;

        // 同步更新pos
        t = pos[h[x]];
        pos[h[x]] = pos[h[y]];
        pos[h[y]] = t;
    }

    // 向下调整堆，传入一个向下调整的编号
    public static void siftdown(int i) {
        int t;                            // 一个临时变量
        boolean isNoAdjust = false;       // 用以标记是否还需向下调整
        while (i*2 <= size && !isNoAdjust) {
            if (dis[h[i]] > dis[h[i*2]]) {
                t = i*2;
            } else {
                t = i;
            }
            if (i*2+1 <= size) {
                if (dis[h[t]] > dis[h[i*2+1]]) {
                    t = i*2+1;
                }
            }
            if (t != i) {
                swap(t, i);
                i = t;
            } else {
                isNoAdjust = true;
            }
        }
    }

    // 向上调整，传入一个需要向上调整的结点编号i
    public static void siftup(int i) {
        boolean isNoAdjust = false;
        if (i == 1) return;     // 已是堆顶，直接返回
        while (i != 1 && !isNoAdjust) {
            if (dis[h[i]] < dis[h[i/2]]) {
                swap(i, i/2);
            } else {
                isNoAdjust = true;
            }
            i /= 2;
        }
    }

    // 堆顶弹出元素
    public static int popH() {
        int t = h[1];
        pos[t] = 0;
        h[1] = h[size];
        pos[h[1]] = 1;
        size --;
        siftdown(1);
        return t;
    }
}
