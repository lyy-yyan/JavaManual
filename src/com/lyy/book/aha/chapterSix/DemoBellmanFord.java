package com.lyy.book.aha.chapterSix;

import java.util.Scanner;

/*
测试样例:
5 5
2 3 2
1 2 -3
1 5 5
4 5 2
3 4 3
输出：
0 -3 -1 2 4
 */

public class DemoBellmanFord {
    public static final int MAX = 999999;
    public static void main(String[] args) {
        int[] u = new int[10];
        int[] v = new int[10];
        int[] w = new int[10];
        Scanner in = new Scanner(System.in);
        int vNum = in.nextInt();
        int eNum = in.nextInt();
        for (int i = 1; i <= eNum; i++) {
            u[i] = in.nextInt();
            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }

        int[] dis = new int[10];
        for (int i = 0; i < dis.length; i++) {
            dis[i] = MAX;
        }
        dis[1] = 0;

        boolean update = false;
        for (int k = 1; k <= vNum - 1; k++) {
            update = false;
            for (int i = 1; i <= eNum; i++) {
                if (dis[v[i]] > dis[u[i]] + w[i]) {
                    dis[v[i]] = dis[u[i]] + w[i];
                    update = true;
                }
            }
            if (!update) {
                break;
            }
        }

        System.out.print("dis数组：");
        for (int i = 1; i <= vNum; i++) {
            System.out.print(dis[i] + " ");
        }
        System.out.println();

        /*
        检测图是否含有负权回路：
        在n-1次松弛后，dis数组不会再发生变化。
        若还发生变化，则存在负权回路。
         */
        update = false;
        for (int i = 1; i <= eNum; i++) {
            if (dis[v[i]] > dis[u[i]] + w[i]) {
                update = true;
            }
        }
        if (update) {
            System.out.println("此图存在负权回路");
        }else {
            System.out.println("此图不存在负权回路");
        }

        in.close();
    }
}
