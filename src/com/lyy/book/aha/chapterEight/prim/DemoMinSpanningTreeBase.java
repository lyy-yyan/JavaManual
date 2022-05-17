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
// Prim算法，邻接矩阵存储，遍历dis数组
public class DemoMinSpanningTreeBase {
    public static final int MAX = 99999999;       // 不可修改的最大值，表无穷
    public static int[][] edges = new int[7][7];  // 用于存储边
    public static int[] dis = new int[7];         // 用以存储各个顶点到树的最小距离
    public static int[] book = new int[7];        // 用以记录该顶点是否在树内
    public static int count = 0;                  // 用以记录生成树中顶点的个数
    public static int sum = 0;                    // 用以存储生成树路径之和
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nodeNum = in.nextInt();
        int edgeNum = in.nextInt();

        // 初始化edges[][]
        for (int i = 1; i <= nodeNum; i++) {
            for (int j = 1; j <= nodeNum; j++) {
                if (i == j) {
                    edges[i][j] = 0;
                } else {
                    edges[i][j] = MAX;
                }
            }
        }

        // 读入边
        for (int i = 1; i <= edgeNum; i++) {
            int node1 = in.nextInt();
            int node2 = in.nextInt();
            int w = in.nextInt();
            edges[node1][node2] = w;
            // 无向图，需要反转再存储一次
            edges[node2][node1] = w;
        }
        in.close();

        // 初始化dis数组，即一开始是1号顶点到各个顶点的距离
        if (nodeNum >= 0) System.arraycopy(edges[1], 1, dis, 1, nodeNum);

        // Prim核心部分
        book[1] = 1;
        count ++;
        while (count < nodeNum) {
            int min = MAX;
            int j = 1;
            // 找到最小的dis
            for (int i = 1; i <= nodeNum; i++) {
                if (book[i] == 0 && dis[i] < min) {
                    min = dis[i];
                    j = i;
                }
            }
            book[j] = 1;
            count ++;
            sum += dis[j];
            // 以j为中间点，更新dis
            for (int k = 1; k <= nodeNum; k++) {
                if (book[k] == 0 && dis[k] > edges[j][k]) {
                    dis[k] = edges[j][k];
                }
            }
        }

        System.out.println(sum);
    }
}
