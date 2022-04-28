package com.lyy.book.aha.chapterSix;

import java.util.Arrays;
import java.util.Scanner;
/*
测试样例：
5 7
1 2 2
1 5 10
2 3 3
2 5 7
3 4 4
4 5 5
5 3 6
输出结果：
0 2 5 9 9
 */

// 队列优化的BellmanFord算法
public class DemoQueueOptimizedBellmanFord {
    public static final int MAX = 999999;
    public static int start = 1;    // 源点

    public static void main(String[] args) {
        // 使用邻接表存储图
        int[] u = new int[10];
        int[] v = new int[10];
        int[] w = new int[10];
        int[] first = new int[10];
        int[] next = new int[10];
        // 初始化first数组
        Arrays.fill(first, -1);

        Scanner in = new Scanner(System.in);
        // vNum顶点数 eNum边数
        int vNum = in.nextInt();
        int eNum = in.nextInt();
        for (int i = 1; i <= eNum; i++) {
            u[i] = in.nextInt();
            v[i] = in.nextInt();
            w[i] = in.nextInt();
            // 下面两句是建立邻接表的关键
            next[i] = first[u[i]];
            first[u[i]] = i;
        }
        in.close();

        int[] dis = new int[10];    // 记录源点到每个点的最短举例
        int[] que = new int[101];   // 优化队列
        int head = 1;
        int tail = 1;
        int[] book = new int[10];   // 记录哪些点已经在队列中
        int[] count = new int[10];  // 记录每个点进入队列的次数

        // 初始化dis数组
        Arrays.fill(dis, MAX);
        dis[start] = 0;
        // 初始化book数组
        Arrays.fill(book, 0);
        // 初始化count数组
        Arrays.fill(count, 0);

        // 源点入队
        que[tail] = start;
        tail ++;
        book[start] = 1;
        count[start] ++;

        int k; // 当前边号
        while (head < tail) { // 队列不为空时循环
            k = first[que[head]];
            while (k != -1) { // 扫描当前顶点的所有边
                if (dis[v[k]] > dis[u[k]] + w[k]) { // 是否可以松弛
                    dis[v[k]] = dis[u[k]] + w[k];
                    if (book[v[k]] == 0) {
                        que[tail] = v[k];
                        tail ++;
                        book[v[k]] = 1;
                        count[v[k]] ++;
                    }
                }
                k = next[k];
            }
            book[que[head]] = 0;
            head ++;
        }

        // 输出dis数组
        for (int i = 1; i <= vNum; i++) {
            System.out.print(dis[i] + " ");
        }
        System.out.println();

        // 判断是否存在负权回路
        boolean flag = false;
        for (int i = 1; i <= vNum; i++) {
            if (count[i] > vNum) {
                flag = true;
                System.out.println("存在负权回路");
            }
        }
        if (!flag) {
            System.out.println("不存在负权回路");
        }
    }
}
