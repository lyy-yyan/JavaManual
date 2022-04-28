package com.lyy.book.aha.chapterFour;

public class Dfs0 {
    public static void main(String[] args) {
//        int[] nums = {1,5,7};
//        dfsFullArray(nums);
//        solution3_1();
        solution4_2();
    }

    //输入一个数组，给出该数组的全排列
    public static void dfsFullArray(int[] nums) {
        int[] ans = new int[nums.length];
        int[] book = new int[nums.length];
        dfsFullArray(nums, ans, book, 0);
    }
    public static void dfsFullArray(int[] nums, int[] ans, int[] book, int step) {
        if (step >= nums.length) {
            for (int ansNum : ans) {
                System.out.print(ansNum + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (book[i] == 0) {
                ans[step] = nums[i];
                book[i] = 1;
                dfsFullArray(nums, ans, book, step+1);
                book[i] = 0;
            }
        }
        return;
    }

    //_ _ _ + _ _ _ = _ _ _填空输入1~9（不重复）问题的全部答案
    public static int count3_1 = 0;
    public static void solution3_1() {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        int[] ans = new int[nums.length];
        int[] book = new int[nums.length];
        solutionDfs3_1(nums, ans, book, 0);
        System.out.println("There are " + count3_1 + " solutions to this problem.");
    }
    public static void solutionDfs3_1(int[] nums, int[] ans, int[] book, int step){
        if (step >= nums.length) {
            if (ans[0]*100 + ans[1]*10 + ans[2] + ans[3]*100 + ans[4]*10 + ans[5] == ans[6]*100 + ans[7]*10 + ans[8]) {
                System.out.println("" + ans[0] + ans[1] + ans[2] + " + " + ans[3] + ans[4] + ans[5] + " = " + ans[6] + ans[7] + ans[8]);
                count3_1 ++;
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (book[i] == 0) {
                ans[step] = nums[i];
                book[i] = 1;
                solutionDfs3_1(nums, ans, book, step+1);
                book[i] = 0;
            }
        }
        return;
    }

    //迷宫的最短距离
    public static final int[][] maze = {{0,0,1,0},{0,0,0,0},{0,0,1,0},{0,1,0,0},{0,0,0,1}};
    public static final int startX = 0;
    public static final int startY = 0;
    public static final int endX = 3;
    public static final int endY = 2;
    public static int minAns = 999999;
    public static void solution4_2() {
        int[][] book = new int[maze.length][maze[0].length];
        solutionDfs4_2(book, startX, startY, 0);
        System.out.println(minAns);
    }
    public static void solutionDfs4_2(int[][] book, int nowX, int nowY, int step) {
        if (nowX == endX && nowY == endY) {
            if (step < minAns) {
                minAns = step;
            }
            return;
        }
        int[][] next = {{0,1},{1,0},{0,-1},{-1,0}};
        for (int i = 0; i < 4; i++) {
            //需设置一个临时值作为下一步要走的点
            int tX = nowX + next[i][0];
            int tY = nowY + next[i][1];

            if (tX >= maze.length || tY >= maze[0].length || tX < 0 || tY < 0) {
                continue;
            }

            if (maze[tX][tY] == 0 && book[tX][tY] == 0) {
                book[tX][tY] = 1;
                solutionDfs4_2(book, tX, tY, step+1);
                book[tX][tY] = 0;
            }
        }
        return;
    }
}
