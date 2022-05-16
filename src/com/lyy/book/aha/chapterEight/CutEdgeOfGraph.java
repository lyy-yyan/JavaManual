package com.lyy.book.aha.chapterEight;

import java.util.Scanner;

/*
测试样例：
6 6
1 4
1 3
4 2
3 2
2 5
5 6
输出结果：
5-6
2-5
 */
// 下面算法在实际使用时一定要用邻接表存储图
// 邻接矩阵的时间复杂度和直接dfs删除每个边看是否连通的时间复杂度几乎一样
public class CutEdgeOfGraph {
    // 顶点数, 边数, 树的根顶点, 时间戳
    public static int vNum, eNum, root, timestamp;
    // 邻接矩阵存储图，时间复杂度O(N^2)
    public static int[][] graph = new int[10][10];
    // 时间戳记录, （不经过父边）能到达最早的祖先记录
    public static int[] timestamps = new int[10];
    public static int[] backEarlFathers = new int[10];

    public static void main(String[] args) {
        // 初始化图
        initGraph();

        // 读入图
        Scanner in = new Scanner(System.in);
        vNum = in.nextInt();
        eNum = in.nextInt();
        for (int i = 1; i <= eNum; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        in.close();

        root = 1;
        PrintCutEdgeDfsFunc(1, root);
    }

    public static void initGraph() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                graph[i][j] = 0;
            }
        }
    }

    public static void PrintCutEdgeDfsFunc(int nowNode, int fatherNode) {
        timestamp ++;
        timestamps[nowNode] = timestamp;
        backEarlFathers[nowNode] = timestamp;
        for (int i = 1; i <= vNum; i++) {
            if (graph[nowNode][i] == 1) {
                if (timestamps[i] == 0) {
                    PrintCutEdgeDfsFunc(i, nowNode);
                    backEarlFathers[nowNode] = Integer.min(backEarlFathers[i], backEarlFathers[nowNode]);
                    if (backEarlFathers[i] > timestamps[nowNode]) {
                        System.out.format("%d-%d\n", nowNode, i);
                    }
                } else if (i != fatherNode) {
                    backEarlFathers[nowNode] = Integer.min(backEarlFathers[nowNode], timestamps[i]);
                }
            }
        }
    }
}
