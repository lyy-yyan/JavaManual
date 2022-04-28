package com.lyy.book.aha.chapterFive;

import java.util.*;

/*
测试样例：
5 8
1 2 2
1 5 10
2 3 3
2 5 7
3 1 4
3 4 4
4 5 5
5 3 3
 */

public class DfsFindShortestPath {
    public static final int MAX = 999999;
    public static int minDis = MAX;
    public static int[] path = new int[10];
    public static int tailPath = 0;
    public static Map<Integer, StringBuilder> pathMap = new HashMap<>();

    public static void main(String[] args) {
        DfsFindShortestPath thisObject = new DfsFindShortestPath();
        int[][] map = new int[10][10];
        int[] book = new int[10];
        initTwoDArray(map);
        initOneDArray(book);
        thisObject.initMap(map);

        Scanner in = new Scanner(System.in);
        int cityNum = in.nextInt();
        int roadNum = in.nextInt();
        for (int i = 0; i < roadNum; i++) {
            int city1 = in.nextInt();
            int city2 = in.nextInt();
            map[city1][city2] = in.nextInt();
        }
        in.close();

        thisObject.printMap(map, cityNum);

        book[1] = 1;
        path[tailPath] = 1;
        tailPath ++;
        thisObject.dfsFunc(1, 5, 0, map, cityNum, book);
        System.out.println("最短路径为：" + minDis);
        System.out.println(pathMap.get(minDis));
    }

    public static void initOneDArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
    }

    public static void initTwoDArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = 0;
            }
        }
    }

    public void printMap(int[][] array, int cityNum) {
        for (int i = 1; i <= cityNum; i++) {
            for (int j = 1; j <= cityNum; j++) {
                System.out.format("%-10d", array[i][j]);
            }
            System.out.println();
        }
    }

    public void initMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (i != j) {
                    map[i][j] = MAX;
                }
            }
        }
    }

    public void dfsFunc(int nowCity, int targetCity, int nowDis, int[][] map, int cityNum, int[] book) {
        if (nowDis >= minDis) return;
        if (nowCity == targetCity) {
            minDis = nowDis;
            printPath(path, minDis);
            return;
        }

        for (int i = 1; i <= cityNum; i++) {
            if (map[nowCity][i] < MAX && book[i] == 0) {
                book[i] = 1;
                path[tailPath] = i;
                tailPath ++;
                dfsFunc(i, targetCity, nowDis+map[nowCity][i], map, cityNum, book);
                tailPath --;
                book[i] = 0;
            }
        }
        return;
    }

    public static void printPath(int[] path, int minDis) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tailPath; i++) {
            if (path[i] != 5) stringBuilder.append(path[i] + "->");
            else stringBuilder.append(5);
        }
        stringBuilder.append("\n");
        pathMap.put(minDis, stringBuilder);
    }
}