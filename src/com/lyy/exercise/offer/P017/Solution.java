package com.lyy.exercise.offer.P017;

import org.junit.Test;

import javax.print.attribute.standard.NumberOfDocuments;
import java.util.Arrays;

public class Solution {
    @Test
    public void testPrintNumbers() {
//        String str = new String("01");
//        String str1 = str.substring(1);
//        System.out.println(str1);
//        System.out.println(Arrays.toString(printNumbers(1)));
//        System.out.println(Arrays.toString(printNumbers(3)));
        System.out.println(Arrays.toString(printBigNumbers(3)));
    }
    // 提交不需要考虑大数
    public int[] printNumbers(int n) {
        int[] ans = new int[(int) (Math.pow(10, n) - 1)];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = i+1;
        }
        return ans;
    }

    // 实际面试需要考虑大数
    static int nowNum = 0;
    static char[] loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static int startBit = 0;
    static int nineNum = 0;
    public String[] printBigNumbers(int n) {
        int num = (int) Math.pow(10, n) - 1;
        String[] ans = new String[num];
        char[] nowStr = new char[n];
        startBit = n - 1;
        dfs(0, n, ans, num, nowStr);
        return ans;
    }
    public void dfs(int bit, int n, String[] ans, int num, char[] nowStr) {
        if (nowNum == num) {
            return;
        }
        if (n == bit) { // 终止条件
            // 每次都检查前面的0，很浪费时间
//            int startBit = 0;
//            String str = new String(nowStr);
//            while (startBit < n && str.charAt(startBit) == '0') startBit ++;
//            if (startBit < n) {
//                ans[nowNum] = str.substring(startBit);
//                nowNum ++;
//            }

            // 更好的办法是计算9的数量
            String str = new String(nowStr).substring(startBit);
            if (!str.equals("0")){
                ans[nowNum] = str;
                nowNum ++;
            }
            if (n - startBit == nineNum) startBit --;

            return;
        }

        // 通过回溯计算有多少个9
        for (int i = 0; i < 10; i++) {
            if (i == 9) nineNum ++;
            nowStr[bit] = loop[i];
            dfs(bit+1, n, ans, num, nowStr);
        }
        // 回溯后，9的计数也要回溯
        nineNum --;
    }
}
