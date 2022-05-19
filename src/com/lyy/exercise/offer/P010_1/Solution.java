package com.lyy.exercise.offer.P010_1;

/*
写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）
测试样例
输入：n = 2
输出：1
输入：n = 5
输出：5
 */

public class Solution {

    //静态值，且不可修改（final关键字修饰不可修改的固定值）
    //利用递归的方法，每次函数都要从头计算斐波那契数列，但其实可以只计算一次，答案返回需要的安哥值即可
    //下面是动态规划：滚动数组的求解方法
    //f0=0 f1=1 f2=1 f3=2 f1 0 0 1 || f2 0 1 1 || f3 1 1 2
    static final int MOD = 1000000007;
    public int fib(int n) {
        if (n == 0||n == 1) return n;
        int x1;
        int x2 = 0;
        int ans = 1;
        for (int i = 1; i < n; i++) {
            x1 = x2;
            x2 = ans;
            ans = (x1 + x2) % MOD;
        }
        return ans;
    }
    //上述方法的时间复杂度是O(n)，空间复杂度是O(1)
    //突然想到，既然都是用算过的值，而且n=100，那么直接开一个100大小的数组，那么只用计算一次
    //这样空间复杂度和时间复杂度都是O(1)
    //如果需要多次输入，这个方法应该是最优的，也可以使用Hashmap存储这些值

    //下列递归的方法超出时间限制，n=41就撑不住了
//    public int fib(int n) {
//        if (n == 0) return 0;
//        if (n == 1) return 1;
//        return (int)((fib(n-1) + fib(n-2)) % MOD);
//    }

    //矩阵快速幂的方法，时间复杂为O(logn)，空间复杂度O(1)
    public int fib_other(int n) {
        if (n < 2) {
            return n;
        }
        //二维数组存储2x2的矩阵
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n - 1);
        return res[0][0];
    }

    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};//单位矩阵
        //快速幂的思路
        //如果幂为奇数，则只乘当前的a
        //如果幂为偶数，幂除以2（即位运算右移一位），a=a^2
        //使用位运算，计算速度更快
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = (int) (((long) a[i][0] * b[0][j] + (long) a[i][1] * b[1][j]) % MOD);
            }
        }
        return c;
    }
}
