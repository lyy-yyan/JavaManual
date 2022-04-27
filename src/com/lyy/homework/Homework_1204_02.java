package homework;

/*
测试样例:
输入： 2
输出： 2

输入： 3
输出： 3
 */

import java.util.Scanner;

public class Homework_1204_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(climbStairs(in.nextInt()));
        in.close();
    }

    public static int climbStairs(int n) {
        if(n==1) return 1;
        int a = 1;
        int b = 2;
        int c;
        for(int i=3;i<=n ;++i){
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
