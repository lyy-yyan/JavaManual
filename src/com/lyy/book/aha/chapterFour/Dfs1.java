package com.lyy.book.aha.chapterFour;

import java.util.Scanner;

public class Dfs1 {

    public static char[][] addr = new char[21][21];
    public static int[][] book = new int[21][21];
    public static int n, m, startX, startY, max, mx, my;

    public static void main(String[] args) {
        for (int i = 0; i < book.length; i++) {
            for (int j = 0; j < book[0].length; j++) {
                book[i][j] = 0;
            }
        }
        inputIntAddr(addr);
        inputStart(3, 3);
        book[startX][startY] = 1;
        max = getNum(startX, startY);
        mx = startX;
        my = startY;
        dfs(startX, startY);
        System.out.println("将炸弹放在(" + mx + ", " + my + ")位置可消灭最多的敌人" + max + "个！");

    }

    public static void dfs(int x, int y) {
        int sum = getNum(x, y);

        if (sum > max) {
            max = sum;
            mx = x;
            my = y;
        }

        for (int k = 0; k < 3; k++) {
            int tx = x + Bfs.next[k][0];
            int ty = y + Bfs.next[k][1];
            if (tx < 0 || tx > n-1 || ty < 0 || ty > m-1) {
                continue;
            }
            if (addr[tx][ty] == '.' && book[tx][ty] == 0) {
                book[tx][ty] = 1;
                dfs(tx, ty);
                book[tx][ty] = 0;
            }
        }
        return;
    }

    public static void inputIntAddr(char[][] addr) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();

        for (int i = 0; i < n; i++) {
            String string = in.next();
            for (int j = 0; j < m; j++) {
                addr[i][j] = string.charAt(j);
            }
        }
        in.close();
    }

    public static void inputStart(int sX, int sY) {
        startX = sX;
        startY = sY;
    }

    public static int getNum(int i, int j) {
        //统计该点可以消灭的敌人数
        int sum = 0;
        int x = i;
        int y = j;

        //向上统计
        while (addr[x][y] != '#') {
            if (addr[x][y] == 'G') {
                sum ++;
            }
            x --;
        }
        //向下统计
        x = i;
        y = j;
        while (addr[x][y] != '#') {
            if (addr[x][y] == 'G') {
                sum ++;
            }
            x ++;
        }
        //向左统计
        x = i;
        y = j;
        while (addr[x][y] != '#') {
            if (addr[x][y] == 'G') {
                sum ++;
            }
            y --;
        }
        //向右统计
        x = i;
        y = j;
        while (addr[x][y] != '#') {
            if (addr[x][y] == 'G') {
                sum ++;
            }
            y ++;
        }
        return sum;
    }
}
