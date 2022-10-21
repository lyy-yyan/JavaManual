package com.lyy.exercise.offer.P019;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    @Test
    public void testIsMatch() {
        Assert.assertEquals(false, isMatch("aa", "a") );
        Assert.assertEquals(true, isMatch("aa", "a*") );
        Assert.assertEquals(true, isMatch("ab", ".*") );
        Assert.assertEquals(true, isMatch("aab", "c*a*b") );
        Assert.assertEquals(false, isMatch("aa", "a") );
    }

    public boolean ansFlag = false;
    public boolean isMatch(String s, String p) {

        return true;
    }

    public void charMatch(String s, String p, int sStep, int pStep) {
        if (sStep == s.length()) {
            if (pStep == p.length()) {
                ansFlag = true;
                return;
            }
            return;
        }
        if (pStep == p.length()) {
            if (sStep == s.length()) {
                ansFlag = true;
                return;
            }
            return;
        }
    }
}
