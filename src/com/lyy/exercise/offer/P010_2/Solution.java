package exercise.leetcode.offer.P010_2;

public class Solution {

    static final int MOD = 1000000007;

    //对于任意级数，对于青蛙都有从前一级出发跳一级和从前两级出发跳两级这两种跳法
    //当前级数的跳法就是前一级的跳法+前两级的跳法
    //这是个动态规划问题，仍然可以使用滚动数组的方法求得答案
    public int numWays(int n) {
        int preTwoAns = 1;
        int preOneAns = 1;
        int ans = 0;
        if (n < 2) {
            if (n == 0) return preTwoAns;
            if (n == 1) return preOneAns;
        }else {
            for (int i = 2; i <= n ; i++) {
                ans = (preOneAns + preTwoAns) % MOD;
                preTwoAns = preOneAns;
                preOneAns = ans;
            }
        }
        return ans;
    }
}
