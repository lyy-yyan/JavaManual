package com.lyy.exercise.offer.P015;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Solution {
    @Test
    public void testHammingWeight() {
        assertEquals(3, new Solution().hammingWeight(00000000000000000000000000001011));
        assertEquals(1, new Solution().hammingWeight(00000000000000000000000010000000));
//        assertEquals(31, new Solution().hammingWeight(11111111111111111111111111111101));
    }
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
//        return Integer.bitCount(n);
        // 返回指定 int 值的二进制补码表示中的一位数。这个函数有时被称为人口计数。

        // 循环检查二进制位
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count ++;
            }
        }
        return count;
    }
}
