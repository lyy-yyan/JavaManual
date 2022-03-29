package com.lyy.office.p012;

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
            return;
        }
    }
}

//题解
/*
class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if(k == word.length - 1) return true;
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                      dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }
}

作者：jyd
链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/solution/mian-shi-ti-12-ju-zhen-zhong-de-lu-jing-shen-du-yo/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
