package com.lyy.exercise.offer.P014_1;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.format;

public class Solution {
    @Test
    public void testCuttingRope() {
        assertEquals(1, new Solution().cuttingRope(2));
        assertEquals(2, new Solution().cuttingRope(3));
        assertEquals(4, new Solution().cuttingRope(4));
        assertEquals(9, new Solution().cuttingRope(6));
        assertEquals(36, new Solution().cuttingRope(10));
    }

    public int cuttingRope(int n) {
        if (n <= 3) {
            return n-1;
        }
        int maxProduct = 1; // 最大乘积
        int[] k = new int[n/2+1]; // 保存分段
        int base = 2;
        // m为分了多少段
        for (int m = n/2; m > 1; m--) {
            int product = 1;
            Arrays.fill(k,0, m, base);
            int index = 0;
            for (int surplus = n - (m * base); surplus > 0; surplus--) {
                k[index] ++;
                index ++;
                if (index == m) {
                    base ++;
                    index = 0;
                }
            }
            for (int i = 0; i < m; i++) {
                product *= k[i];
            }
            if (maxProduct < product) {
                maxProduct = product;
            }
        }
        return maxProduct;
    }
}
