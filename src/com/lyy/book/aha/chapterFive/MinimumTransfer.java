package com.lyy.book.aha.chapterFive;

import java.util.Scanner;

/*
测试样例：
5 7 1 5
1 2
1 3
2 3
2 4
3 4
3 5
4 5
 */

//下面题目也可以用dfs解决，但是这里用bfs会更快，因为bfs更加适用所有边的权值相同的情况
public class MinimumTransfer {
    public static final int MAX = 999999;
    public static void main(String[] args) {
        int[][] map = new int[10][10];
        initMap(map);

        int[] book = new int[10];
        for (int i = 0; i < book.length; i++) {
            book[i] = 0;
        }

        Scanner in = new Scanner(System.in);
        int cityNum = 0;
        int roadNum = 0;
        int startCity = 0;
        int endCity = 0;
        cityNum = in.nextInt();
        roadNum = in.nextInt();
        startCity = in.nextInt();
        endCity = in.nextInt();
        for (int i = 0; i < roadNum; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            map[start][end] = 1;
            map[end][start] = 1;
        }
        in.close();
        printMap(map, cityNum);

        int ans = bfsFunc(map, book, cityNum, startCity, endCity);
        System.out.println(ans);
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

    public static void printMap(int[][] map, int cityNum) {
        for (int i = 1; i <= cityNum; i++) {
            for (int j = 1; j <= cityNum; j++) {
                System.out.format("%-10d", map[i][j]);
            }
            System.out.println();
        }
    }

    public static int bfsFunc(int[][] map,int[] book, int cityNum, int startCity, int endCity) {
        Point[] points = new Point[10];
        int head = 0;
        int tail = 0;
        boolean flag = false;

        points[tail] = new Point(startCity, 0);
        book[startCity] = 1;
        tail ++;

        while (head < tail) {
            int nowCity = points[head].getNowCity();
            for (int i = 1; i <= cityNum; i++) {
                if (map[nowCity][i] < MAX && book[i] == 0) {
                    points[tail] = new Point(i, points[head].getTransferNum()+1);
                    tail ++;
                    book[i] = 1;
                }
                if (points[tail-1].getNowCity() == endCity) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
            head ++;
        }
        return points[tail-1].getTransferNum();
    }
}
