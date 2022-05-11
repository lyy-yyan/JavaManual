package com.lyy.book.aha.chapterEight;

import java.util.Arrays;
import java.util.Scanner;

/*
最小生成树
测试样例：
6 9
2 4 11
3 5 13
4 6 3
5 6 4
2 3 6
4 5 7
1 2 1
3 4 9
1 3 2
输出结果：
19
 */
public class DemoMinSpanningTree {
    public static Edge[] edges = new Edge[10];
    public static void main(String[] args) {
        int n, m;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();   // 点数
        m = in.nextInt();   // 边数
        for (int i = 1; i <= m; i++) {
            edges[i] = new Edge();
            edges[i].setU(in.nextInt());
            edges[i].setV(in.nextInt());
            edges[i].setW(in.nextInt());
        }
        in.close();

        quicksort(1, m);

        for (int i = 1; i <= m; i++) {
            System.out.println("edge.w=" + edges[i].getW());
        }

        int[] nodeFather = new int[10];
        for (int i = 1; i <= n; i++) {
            nodeFather[i] = i;
        }

        System.out.println(kruskalFunc(nodeFather, m, n));
    }

    public static void quicksort(int left, int right) {
        if (left > right) {
            return;
        }
        Edge edge;
        int i = left;
        int j = right;
        while (i != j) {
            while (edges[j].getW() >= edges[left].getW() && i < j) {
                j --;
            }
            while (edges[i].getW() <= edges[left].getW() && i < j) {
                i ++;
            }
            if (i < j) {
                edge = edges[i];
                edges[i] = edges[j];
                edges[j] = edge;
            }
        }
        edge = edges[left];
        edges[left] = edges[i];
        edges[i] = edge;

        quicksort(left, i-1);
        quicksort(i+1, right);
    }

    public static int getFather(int[] nodeFather, int node) {
        if (nodeFather[node] == node) {
            return node;
        } else {
            nodeFather[node] = getFather(nodeFather, nodeFather[node]);
            return nodeFather[node];
        }
    }

    public static boolean isSameFatherAndMerge(int[] nodeFather, int node1, int node2) {
        int node1f = getFather(nodeFather, node1);
        int node2f = getFather(nodeFather, node2);
        if (node1f != node2f) {
            nodeFather[node2f] = node1f;
            return false;
        } else {
            return true;
        }
    }

    public static int kruskalFunc(int[] nodeFather, int m, int n) {
        int sum = 0;
        int count = 0;
        for (int i = 1; i <= m; i++) {
            if (!isSameFatherAndMerge(nodeFather, edges[i].getU(), edges[i].getV())) {
                count ++;
                sum += edges[i].getW();
            }
            if (count == n-1) {
                break;
            }
        }
        return sum;
    }
}

class Edge {
    private int u;
    private int v;
    private int w;

    Edge(){u = 0; v = 0; w = 0;}
    Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    public void setU(int u) {
        this.u = u;
    }

    public void setV(int v) {
        this.v = v;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getU() {
        return u;
    }

    public int getV() {
        return v;
    }

    public int getW() {
        return w;
    }

    @Override
    public String toString() {
        return "u=" + this.u + ", v=" + this.v + ", w=" + this.w;
    }
}
