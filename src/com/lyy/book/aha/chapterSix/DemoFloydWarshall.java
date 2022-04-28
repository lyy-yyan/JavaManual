package com.lyy.book.aha.chapterSix;

import java.util.Scanner;

/*
测试样例：
4 8
1 2 2
1 3 6
1 4 4
2 3 3
3 1 7
3 4 1
4 1 5
4 3 12
 */
public class DemoFloydWarshall {
    public static final int MAX = 999999;

    public static void main(String[] args) {
        int[][] map = new int[10][10];
        initMap(map);
        Scanner in = new Scanner(System.in);
        int vNum = in.nextInt();
        int eNum = in.nextInt();
        for (int i = 0; i < eNum; i++) {
            map[in.nextInt()][in.nextInt()] = in.nextInt();
        }
        in.close();

        printMap(map, vNum);

        funcFloyd(map, vNum);

        printMap(map, vNum);
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

    public static void funcFloyd(int[][] map, int vNum) {
        for (int k = 1; k <= vNum; k++) {
            for (int i = 1; i <= vNum; i++) {
                for (int j = 1; j <= vNum; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
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
}
