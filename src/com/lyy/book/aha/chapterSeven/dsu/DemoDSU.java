package com.lyy.book.aha.chapterSeven.dsu;

import java.util.Scanner;

// 并查集简例
/*
测试样例：
10 9
1 2
3 4
5 2
4 6
2 6
8 7
9 7
1 6
2 4
输出结果：
3
 */
public class DemoDSU {
    public static void main(String[] args) {
        int[] f = new int[20];
        int n, m;   // n表示共有几个结点，m表示共有几个线索
        Scanner in = new Scanner(System.in);
        System.out.println("Please wait a moment after entering the values for n and m.");
        n = in.nextInt();
        m = in.nextInt();

        init_f(f, n);   // 先初始化f数组

        for (int i = 1; i <= m; i++) {
            int nodeX = in.nextInt();
            int nodeY = in.nextInt();
            merge(f, nodeX, nodeY);
        }
        in.close();

        System.out.println("sum_ancestor=" + sum_ancestor(f, n));
    }

    public static void init_f(int[] f, int n) {
        for (int i = 1; i <= n; i++) {
            f[i] = i;
        }
    }

    public static void merge(int[] f, int nodeX, int nodeY) {
        int ancestorX = get_ancestor(f, nodeX);
        int ancestorY = get_ancestor(f, nodeY);
        if (ancestorX != ancestorY) {
            f[ancestorY] = ancestorX;
        }
    }

    public static int get_ancestor(int[] f, int node) {
        if (f[node] == node) {
            return node;
        }else {
            f[node] = get_ancestor(f, f[node]);
            return f[node];
        }
    }

    public static int sum_ancestor(int[] f, int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (f[i] == i) {
                sum ++;
            }
        }
        return sum;
    }
}
