package com.lyy.exercise.offer.P017;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    @Test
    public void testPrintNumbers() {
        System.out.println(Arrays.toString(printNumbers(1)));
        System.out.println(Arrays.toString(printNumbers(3)));
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
    public String[] printBigNumbers(int n) {
        String[] ans = new String[(int) (Math.pow(10, n) - 1)];

        return ans;
    }
}
