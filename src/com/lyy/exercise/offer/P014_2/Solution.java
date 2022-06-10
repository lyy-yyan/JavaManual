package com.lyy.exercise.offer.P014_2;

import java.lang.management.MemoryManagerMXBean;

public class Solution {
    public static final int MOD = 1000000007;
    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        long base = 1;
        for (int i = 0; i < a - 1; i++) {
            base = 3 * base % MOD;
        }
        
        if(b == 0) {
            return (int)(3 * base % MOD);
        }
        if(b == 1) {
            return (int)(4 * base % MOD);
        }
        return (int)(6 * base % MOD);
    }
}
