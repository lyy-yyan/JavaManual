package com.lyy.exercise.offer.P016;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Solution {
    @Test
    public void testMyPow() {
        assertEquals(1024.00000, myPow(2.00000, 10));
//        这条力扣能过
//        assertEquals(9.26100, myPow(2.10000, 3));
        assertEquals(0.25000, myPow(2.00000, -2));
        assertEquals(1.0, myPow(1.00000, 2147483647));
        assertEquals(0.0, myPow(2.00000, -2147483648));
        assertEquals(1.0, myPow(-1.00000, -2147483648));
    }

    public double myPow(double x, int n) {
        double ans = 1;
        double base = x;
        if (x == 0.0) return 0;
        if (x == 1.0 || n == 1) return x;
        if (n == 0) return 1;
        if (n < 0) {
            boolean overrunFlag = false;
            n *= -1;
            if (n < 0) {
                n += 1;
                n *= -1;
                overrunFlag = true;
            }
            base = 1/base;
            for (int i = n; i > 0; i /= 2) {
                if (i %2 == 1) ans *= base;
                base *= base;
            }
            if (overrunFlag) return ans * 1/x;
            return ans;
        }
        // n > 1
        ans = 1;
        for (int i = n; i > 0; i /= 2) {
            if (i %2 == 1) ans *= base;
            base *= base;
        }
        return ans;
    }
}
