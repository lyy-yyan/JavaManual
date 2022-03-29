package com.lyy.book.aha.chapterFour;
import java.util.Scanner;

/*
bfs1测试样例：
5 4
0 0 1 0
0 0 0 0
0 0 1 0
0 1 0 0
0 0 0 1
 */

/*
bfs2测试样例：
13 13
#############
#GG.GGG#GGG.#
###.#G#G#G#G#
#.......#..G#
#G#.###.#G#G#
#GG.GGG.#.GG#
#G#.#G#.#.#.#
##G...G.....#
#G#.#G###.#G#
#...G#GGG.GG#
#G#.#G#G#.#G#
#GG.GGG#G.GG#
#############
 */

//可以用队列来模拟bfs的过程
public class Bfs {

    public static int n, m, startX, startY;
    public static int[][] next = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
//        bfs1();
        bfs2();
    }

    //再解炸弹人
    public static char[][] addr = new char[20][20];
    public static int[][] book = new int[20][20];
    public static void bfs2() {
        Note[] que = new Note[401];
        int head = 1;
        int tail = 1;
        for (int i = 0; i < book.length; i++) {
            for (int j = 0; j < book[0].length; j++) {
                book[i][j] = 0;
            }
        }
        inputIntAddr(addr);
        inputStart(3, 3);

        que[tail] = new Note(startX, startY);
        tail ++;
        book[startX][startY] = 1;
        int max = getNum(startX, startY);
        int mx = startX;
        int my = startY;

        while (head < tail) {
            int tx, ty;
            for (int k = 0; k < 3; k++) {
                tx = que[head].getX() + next[k][0];
                ty = que[head].getY() + next[k][1];

                if (tx < 0 || tx > n-1 || ty < 0 || ty > m-1) {
                    continue;
                }

                if (addr[tx][ty] == '.' && book[tx][ty] == 0) {
                    book[tx][ty] = 1;
                    que[tail] = new Note(tx, ty);
                    tail ++;

                    int sum = getNum(tx, ty);
                    if (sum > max) {
                        max = sum;
                        mx = tx;
                        my = ty;
                    }
                }
            }
            head ++;
        }
        System.out.println("将炸弹放在("+ mx + ", " + my + ")处可以消灭最多的敌人，数量为：" + max);
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

//    public static void bfs1() {//层层递进
//
//        Point[] points = new Point[2501];
//        int[][] addr = new int[51][51];//地图
//        int[][] book = new int[51][51];//记录走过的点
//        //定义一个用于表示走的方向的数组
//
//        inputIntAddr(addr);
//        inputStartAndEnd(1, 1, 4, 3);
//
//        for (int i = 0; i <= n; i++) {
//            for (int j = 0; j < m; j++) {
//                book[i][j] = 0;
//            }
//        }
//
//        int head = 1;
//        int tail = 1;
//        points[tail] = new Point(startX, startY, 0, 0);
//        tail ++;
//        book[startX][startY] = 1;
//
//        boolean flag = false;//用来标记是否到达目标点
//        //当队列不为空的时候进行查找
//        while (head < tail) {
//            //枚举四个方向
//            for (int i = 0; i <= 3; i++) {
//                int tempX = points[head].getX() + next[i][0];
//                int tempY = points[head].getY() + next[i][1];
//
//                //判断是否越界
//                if (tempX < 1 || tempY < 1 || tempX > n || tempY > m) {
//                    continue;
//                }
//                //判断是否能够走或者是否已经在队列中
//                if (addr[tempX][tempY] == 0 && book[tempX][tempY] == 0) {
//                    book[tempX][tempY] = 1;
//                    points[tail] = new Point(tempX, tempY, head, points[head].getStep()+1);
//                    tail ++;
//                }
//
//                //查找是否到目标点
//                if (tempX == endX && tempY == endY) {
//                    flag = true;
//                    break;
//                }
//            }
//            if (flag) {
//                break;
//            }
//            head ++;
//        }
//
//        //打印队列中末尾最后一个点（目标点）的步数
//        //注意tail是指向队尾的下一个位置，所以需要-1
//        System.out.println(points[tail-1].getStep());
//    }
//
//    public static void inputIntAddr(int[][] addr) {
//        Scanner in = new Scanner(System.in);
//        n = in.nextInt();
//        m = in.nextInt();
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                addr[i][j] = in.nextInt();
//            }
//        }
//        in.close();
//    }
//
//    public static void inputStartAndEnd(int sX, int sY, int eX, int eY) {
//        startX = sX;
//        startY = sY;
//        endX = eX;
//        endY = eY;
//    }

}
