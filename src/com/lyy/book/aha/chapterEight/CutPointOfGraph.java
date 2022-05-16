package com.lyy.book.aha.chapterEight;

/*
测试样例：
6 7
1 4
1 3
4 2
3 2
2 5
2 6
5 6
输出结果：
2
 */

import java.util.Scanner;

public class CutPointOfGraph {
    public static int nodeNum;  // 节点数目
    public static int edgeNum;  // 边的数目
    public static int[][] graph = new int[10][10];  // 邻接矩阵存储图，实际使用时请使用邻接表
    public static int root = 0; // 根

    public static int[] timestamps = new int[10];   // 记录各节点时间戳
    public static int[] backEarlFathers = new int[10];  // 记录各节点在不经过割点时能返回的最早祖先
    public static boolean[] isCutPoints = new boolean[10];  // 记录各节点是否是割点
    public static int timestamp = 0;    // 时间戳递增变量，初始为0

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        nodeNum = in.nextInt();
        edgeNum = in.nextInt();
        // 初始化图
        for (int i = 1; i <= nodeNum; i++) {
            for (int j = 1; j <= nodeNum; j++) {
                graph[i][j] = 0;
            }
        }
        // 读入图
        for (int i = 1; i <= edgeNum; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        in.close();

        root = 1;
        cutPointDfsFunc(1, root);
        for (int i = 1; i <= nodeNum; i++) {
            if (isCutPoints[i]) System.out.println(i);
        }

    }

    // 割点算法核心
    public static void cutPointDfsFunc(int nowNode, int fatherNode) {
        int child = 0;  // 用以记录当前顶点的儿子个数
        timestamp ++;
        timestamps[nowNode] = timestamp;
        backEarlFathers[nowNode] = timestamp;
        for (int i = 1; i <= nodeNum; i++) {    // 枚举与当前顶点有边相连的顶点i
            if (graph[nowNode][i] == 1) {
                if (timestamps[i] == 0) {   // 如果顶点i的时间戳为0，说明还没被访问过
                    child ++;
                    cutPointDfsFunc(i, nowNode);
                    // 更新当前顶点能否访问最早顶点的时间戳
                    backEarlFathers[nowNode] = Integer.min(backEarlFathers[nowNode], backEarlFathers[i]);
                    // 如果当前顶点不是根点并且满足儿子节点能到达的最早祖先>=当前节点的时间戳，即不经过当前节点便不能返回之前的祖先
                    if (nowNode != root && backEarlFathers[i] >= timestamps[nowNode]) {
                        isCutPoints[nowNode] = true;
                    }
                    // 如果当前顶点是根节点，该根节点如果有两个儿子，则当前节点也为割点
                    if (nowNode == root && child == 2) {
                        isCutPoints[nowNode] = true;
                    }
                } else if (i != fatherNode) {   // i节点被访问过，但不是从当前节点下访问下来的，而且i不是当前节点的父节点，需要更新时间戳
                    backEarlFathers[nowNode] = Integer.min(backEarlFathers[nowNode], timestamps[i]);
                }
            }
        }
    }
}
