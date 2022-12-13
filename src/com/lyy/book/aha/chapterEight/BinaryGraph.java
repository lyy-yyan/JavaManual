package com.lyy.book.aha.chapterEight;

import java.util.Arrays;
import java.util.Scanner;

/*
测试样例：
6 5
1 4
1 5
2 5
2 6
3 4
输出结果：
true
3
测试样例：
6 6
1 3
1 4
1 5
2 5
2 6
3 4
输出结果：
false
 */
public class BinaryGraph {
    public static int[][] graph = new int[10][10];  // 邻接矩阵存储图
    public static int[] match = new int[10];        // 匹配记录
    public static int[] book = new int[10];         // 搜索访问记录
    public static int vNum;     // 顶点数
    public static int eNum;     // 边数

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        vNum = in.nextInt();
        eNum = in.nextInt();
        // 读入图
        for (int i = 1; i <= eNum; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        in.close();

        // 初始化
        Arrays.fill(match, 0);
        Arrays.fill(book, 0);

        // 判断是否为二分图
        System.out.println(isBinaryGraph());

        // 如果是二分图
        int sum = 0;    // 记录匹配数
        if (isBinaryGraph()) {
            for (int i = 1; i <= vNum; i++) {
                Arrays.fill(book, 0);
                if (findMaxMatchDfsFunc(i)) sum ++;
            }
            System.out.println(sum);
        }

    }

    public static boolean isBinaryGraph() {
        int[] vColorBook = new int[10];
        int sumColor = 0;
        Arrays.fill(vColorBook, 0);
        for (int i = 1; i <= vNum; i++) {
            if (sumColor == vNum) {
                break;
            }
            switch (vColorBook[i]) {
                case 0 :
                    vColorBook[i] = 1;
                    sumColor ++;
                    for (int j = 1; j <= vNum; j++) {
                        if (graph[i][j] == 1) {
                            switch (vColorBook[j]) {
                                case 0:
                                    vColorBook[j] = 2;
                                    sumColor ++;
                                    break;
                                case 1:
                                    return false;
                                case 2:
                                    break;
                            }
                        }
                    }
                    break;
                case 2:
                    for (int j = 1; j <= vNum; j++) {
                        if (graph[i][j] == 1) {
                            switch (vColorBook[j]) {
                                case 0:
                                    vColorBook[j] = 1;
                                    sumColor ++;
                                    break;
                                case 1:
                                    break;
                                case 2:
                                    return false;

                            }
                        }
                    }
                    break;
                default: break;
            }
        }
        return true;
    }

    public static boolean findMaxMatchDfsFunc(int nowNode) {
        for (int i = 1; i <= vNum; i++) {
            if (book[i] == 0 && graph[nowNode][i] == 1) {
                book[i] = 1;
                // 如果i未被配对或者能找到新的配对
                if (match[i] == 0 || findMaxMatchDfsFunc(match[i])) {
                    match[i] = nowNode;
                    match[nowNode] = i;
                    return true;
                }
            }
        }
        return false;
    }
}
