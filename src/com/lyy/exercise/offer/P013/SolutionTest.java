package com.lyy.exercise.offer.P013;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static junit.framework.TestCase.assertEquals;

public class SolutionTest {

    // 单元测试
    @Test
    public void testMovingCount() {
        assertEquals(3, new SolutionTest().movingCount(2, 3, 1));
        assertEquals(1, new SolutionTest().movingCount(3, 1, 0));
        assertEquals(6117, new SolutionTest().movingCount(100, 100, 20));
    }

    // 优化后代码
    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        int ans = 0;
        boolean[][] book = new boolean[101][101];
        int[][] next = new int[][]{{0, 1}, {1, 0}};

        Queue<int[]> queue = new LinkedList<>();
        book[0][0] = true;
        queue.offer(new int[]{0, 0});
        ans ++;

        while (!queue.isEmpty()) {
            int[] headQueue = queue.poll();

            for (int i = 0; i < 2; i++) {
                int tx = headQueue[0] + next[i][0];
                int ty = headQueue[1] + next[i][1];

                if (tx >= 0 && tx <= m-1 && ty >= 0 && ty <= n-1 && !book[tx][ty] && (everyDigitSum(tx) + everyDigitSum(ty)) <= k) {
                    ans ++;
                    book[tx][ty] = true;
                    queue.offer(new int[]{tx, ty});
                }
            }
        }

        return ans;
    }

    public int everyDigitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x%10;
            x /= 10;
        }
        return sum;
    }

    // 首次通过版
//    public int movingCount(int m, int n, int k) {
//        int ans = 0;
//        int[][] book = new int[101][101];
//        int[][] next = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
//        int[][] queue = new int[10001][2];
//        int head = 0;
//        int tail = 0;
//        book[0][0] = 1;
//        queue[tail][0] = 0;
//        queue[tail][1] = 0;
//        tail ++;
//        ans ++;
//
//        while (head < tail) {
//
//            for (int i = 0; i < 4; i++) {
//                int tx = queue[head][0] + next[i][0];
//                int ty = queue[head][1] + next[i][1];
//
//                if (tx >= 0 && tx <= m-1 && ty >= 0 && ty <= n-1 && book[tx][ty] == 0 && everyDigitSum(tx, ty) <= k) {
//                    ans ++;
//                    book[tx][ty] = 1;
//                    queue[tail][0] = tx;
//                    queue[tail][1] = ty;
//                    tail ++;
//                }
//            }
//            head ++;
//        }
//
//        return ans;
//    }
//
//    public int everyDigitSum(int x, int y) {
//        int sum = 0;
//        while (x > 0) {
//            sum += x%10;
//            x /= 10;
//        }
//        while (y > 0) {
//            sum += y%10;
//            y /= 10;
//        }
//        return sum;
//    }
}
