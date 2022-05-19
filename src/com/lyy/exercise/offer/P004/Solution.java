package com.lyy.exercise.offer.P004;

import java.util.Scanner;

/*
测试样例
输入：
5 5
1 4 7 11 15
2 5 8 12 19
3 6 9 16 22
10 13 14 17 24
18 21 23 26 30
5
输出：
true
输入：
5 5
1 4 7 11 15
2 5 8 12 19
3 6 9 16 22
10 13 14 17 24
18 21 23 26 30
20
输出：
false
 */

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        Solution ob = new Solution();
        System.out.print("please input target:");
        int target = in.nextInt();
        boolean ans = ob.findNumberIn2DArrayOther(matrix, target);
        System.out.println("ans:" + ans);

        in.close();
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //考虑数组不存在的情况
        if (matrix == null||matrix.length == 0||matrix[0].length == 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    //考虑数组特性：每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
    //下面重写一个高效函数
    public boolean findNumberIn2DArrayOther(int[][] matrix, int target) {
        //考虑数组不存在的情况
        if (matrix == null||matrix.length == 0||matrix[0].length == 0) {
            return false;
        }
        //target先与数组最右上角的数字做比较，如果小于当前值则左移一列，如果大于当前值则下移一行
        for (int i = 0, j = matrix[0].length-1; j >= 0 && i < matrix.length; ) {
            if (target == matrix[i][j]) {
                return true;
            }else if (target < matrix[i][j]) {
                j --;
            }else {
                i ++;
            }
        }
        return false;
    }
}
