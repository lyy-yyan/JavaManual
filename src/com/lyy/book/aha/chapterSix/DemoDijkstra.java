package com.lyy.book.aha.chapterSix;

import java.util.Scanner;

/*
测试样例：
6 9
1 2 1
1 3 12
2 3 9
2 4 3
3 5 5
4 3 4
4 5 13
4 6 15
5 6 4
输出dis数组：
0 1 8 4 13 17
 */

public class DemoDijkstra {
    public static final int MAX = 999999;
    public static void main(String[] args) {

        int[][] map = new int[10][10];
        int[][] mapAL = new int[5][10];
        Scanner in = new Scanner(System.in);

        //读入图：使用邻接矩阵
        initMap(map);
        int vNum = in.nextInt();
        int eNum = in.nextInt();
        for (int i = 0; i < eNum; i++) {
            map[in.nextInt()][in.nextInt()] = in.nextInt();
        }

        //若用邻接表的方式来存储图，即节省了空间，又降低了遍历时间复杂度
//        initArray(mapAL);
//        // mapAL[0] = U
//        // mapAL[1] = V
//        // mapAL[2] = W
//        // mapAL[3] = first
//        // mapAL[4] = next
//        int vNum = in.nextInt();
//        int eNum = in.nextInt();
//        for (int i = 1; i <= vNum; i++) {
//            mapAL[3][i] = -1;
//        }
//        for (int i = 1; i <= eNum; i++) {
//            mapAL[0][i] = in.nextInt();
//            mapAL[1][i] = in.nextInt();
//            mapAL[2][i] = in.nextInt();
//            mapAL[4][i] = mapAL[3][mapAL[0][i]];
//            mapAL[3][mapAL[0][i]] = i;
//        }

        in.close();
//        printMap(map, vNum);
//        printMapAL(mapAL, vNum);

        int[] dis = new int[10];
        int[] book = new int[10];


        funcDijkstraAM(1, map, dis, book, vNum);    //算法运行时长为：4700 ns
//        funcDijkstraAL(1, mapAL, dis, book, vNum);  //算法运行时长为：3600 ns

    }

    public static void initMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (i == j) {
                    map[i][j] = 0;
                }else {
                    map[i][j] = MAX;
                }
            }
        }
    }

    public static void initArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = 0;
            }
        }
    }

    public static void printMap(int[][] map, int vNum) {
        for (int i = 1; i <= vNum; i++) {
            for (int j = 1; j <= vNum; j++) {
                System.out.format("%-10d", map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printMapAL(int[][] mapAL, int vNum) {
        for (int i = 1; i <= vNum; i++) {
            int k = mapAL[3][i];
            while (k != -1) {
                System.out.printf("%d %d %d\n", mapAL[0][k], mapAL[1][k], mapAL[2][k]);
                k = mapAL[4][k];
            }
        }
    }

    //邻接矩阵存储法：adjacency matrix
    public static void funcDijkstraAM( int start, int[][] map, int[] dis, int[] book, int vNum) {
        for (int i = 0; i < book.length; i++) {
            book[i] = 0;
        }
        for (int i = 1; i <= vNum; i++) {
            dis[i] = map[start][i];
        }
        book[start] = 1;

        long startTime = System.nanoTime();
        for (int i = 1; i <= vNum-1; i++) {
            int minDis = MAX;
            int u = 0;
            for (int j = 1; j <= vNum; j++) {
                if (book[j] == 0 && dis[j] < minDis) {
                    minDis = dis[j];
                    u = j;
                }
            }
            book[u] = 1;
            for (int v = 1; v <= vNum; v++) {
                if (map[u][v] < MAX && dis[u] + map[u][v] < dis[v]) {
                    dis[v] = dis[u] + map[u][v];
                }
            }
        }

        long endTime = System.nanoTime();
        System.out.println("算法运行时长为：" + (endTime-startTime) + " ns");

        for (int i = 1; i <= vNum; i++) {
            System.out.format("%d ", dis[i]);
        }
    }

    //邻接表存储法：adjacency list
    public static void funcDijkstraAL(int start, int[][] mapAL, int[]dis, int[] book, int vNum) {
        for (int i = 0; i < book.length; i++) {
            book[i] = 0;
        }
        for (int i = start+1; i < dis.length; i++) {
            dis[i] = MAX;
        }

        int k = mapAL[3][start];
        while (k != -1) {
            dis[mapAL[1][k]] = mapAL[2][k];
            k = mapAL[4][k];
        }
        book[start] = 1;

        long startTime = System.nanoTime();
        for (int i = 1; i <= vNum-1; i++) {
            int minDis = MAX;
            int u = 0;
            for (int j = 1; j <= vNum; j++) {
                if (book[j] == 0 && dis[j] < minDis) {
                    minDis = dis[j];
                    u = j;
                }
            }
            book[u] = 1;
            k = mapAL[3][u];
            while (k != -1) {
                if (dis[u] + mapAL[2][k] < dis[mapAL[1][k]]) {
                    dis[mapAL[1][k]] = dis[u] + mapAL[2][k];
                }
                k = mapAL[4][k];
            }
        }
        long endTime = System.nanoTime();
        System.out.println("算法运行时长为：" + (endTime-startTime) + " ns");

        for (int i = 1; i <= vNum; i++) {
            System.out.format("%d ", dis[i]);
        }
    }
}
