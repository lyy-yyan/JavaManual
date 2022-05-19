# 剑指 Offer 10- I. 斐波那契数列
## 题目描述
写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：<br />
```
F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
```
斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。<br />
答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。<br />

来源：力扣（LeetCode）<br />
链接：https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof <br />
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。<br />
## 题目要求
- 0 <= n <= 100
## 测试样例
输入：n = 2 <br />
输出：1 <br />

输入：n = 5 <br />
输出：5 <br />
# 官方题解
```java
class Solution {
    public int fib(int n) {
        final int MOD = 1000000007;
        if (n < 2) {
            return n;
        }
        int p, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q; 
            q = r; 
            r = (p + q) % MOD;
        }
        return r;
    }
}
```