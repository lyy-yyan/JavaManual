package com.lyy.exercise.offer.p012;

public class Solution {
    public static int[][] book = new int[200][200];
    public static boolean flag = false;
    public boolean exist(char[][] board, String word) {
        flag = false;
        int rightNums = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    book[i][j] = 1;
                    dfs(board, i, j, word, 1);
                    book[i][j] = 0;
                }
                if (flag) return true;
            }
        }
        return false;
    }

    public void dfs(char[][] board, int i, int j, String word, int rightNums) {
        if (flag)return;//找到一个正确结果后立即返回，不再查找剩余的情况
        if (rightNums == word.length()) {
            flag = true;
            return;
        }
        if (rightNums < word.length()) {
            //可以只看当前ij的符号是否想同，进入其他四个方向后仍然只看当前ij符号，可以精简代码
            //四个方向寻找
            //右
            if (j+1 < board[0].length && book[i][j+1] == 0 && board[i][j+1] == word.charAt(rightNums)) {
                book[i][j+1] = 1;
                dfs(board, i, j+1, word, rightNums+1);
                book[i][j+1] = 0;
            }
            //下
            if (i+1 < board.length && book[i+1][j] == 0 && board[i+1][j] == word.charAt(rightNums)) {
                book[i+1][j] = 1;
                dfs(board, i+1, j, word, rightNums+1);
                book[i+1][j] = 0;
            }
            //左
            if (j-1 >= 0 && book[i][j-1] == 0 && board[i][j-1] == word.charAt(rightNums)) {
                book[i][j-1] = 1;
                dfs(board, i, j-1, word, rightNums+1);
                book[i][j-1] = 0;
            }
            //上
            if (i-1 >= 0 && book[i-1][j] == 0 && board[i-1][j] == word.charAt(rightNums)) {
                book[i-1][j] = 1;
                dfs(board, i-1, j, word, rightNums+1);
                book[i-1][j] = 0;
            }
        }
    }
}
