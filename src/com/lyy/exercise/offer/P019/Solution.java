package com.lyy.exercise.offer.P019;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    @Test
    public void testIsMatch() {
        Assert.assertEquals(false, isMatch("aa", "a"));
        Assert.assertEquals(true, isMatch("aa", "a*"));
        Assert.assertEquals(true, isMatch("ab", ".*"));
        Assert.assertEquals(true, isMatch("aab", "c*a*b"));
        Assert.assertEquals(false, isMatch("aa", "a"));
        Assert.assertEquals(true, isMatch("aaaab", "aa*aab"));
        Assert.assertEquals(false, isMatch("mississippi", "mis*is*p*."));
        Assert.assertEquals(false, isMatch("abcd", "d*"));
        Assert.assertEquals(false, isMatch("ab", ".*c"));
        Assert.assertEquals(true, isMatch("ab", ".*"));
        Assert.assertEquals(true, isMatch("mississippi", "mis*is*ip*."));
        Assert.assertEquals(false, isMatch("aaa", "aaaa"));
    }

    public boolean isMatch(String s, String p) {
        return matchOne(s, p, 0, 0);

        // 官方题解
//        int m = s.length();
//        int n = p.length();
//
//        boolean[][] f = new boolean[m + 1][n + 1];
//        f[0][0] = true;
//        for (int i = 0; i <= m; ++i) {
//            for (int j = 1; j <= n; ++j) {
//                if (p.charAt(j - 1) == '*') {
//                    f[i][j] = f[i][j - 2];
//                    if (matches(s, p, i, j - 1)) {
//                        f[i][j] = f[i][j] || f[i - 1][j];
//                    }
//                } else {
//                    if (matches(s, p, i, j)) {
//                        f[i][j] = f[i - 1][j - 1];
//                    }
//                }
//            }
//        }
//        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    // 个人思路
    public boolean matchOne(String s, String p, int sNow, int pNow) {
        if (pNow == p.length()) return sNow == s.length();
        boolean isMatchNow = sNow < s.length() && (p.charAt(pNow) == s.charAt(sNow) || p.charAt(pNow) == '.');
        if (pNow+1 < p.length() && p.charAt(pNow+1) == '*') {
            return (isMatchNow && matchOne(s, p, sNow+1, pNow)) || (matchOne(s, p, sNow, pNow+2));
        } else {
            return isMatchNow && matchOne(s, p, sNow+1, pNow+1);
        }
    }
}
