# 剑指 Offer 16. 数值的整数次方
## 题目描述
实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。<br />

来源：力扣（LeetCode）<br />
链接：https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof <br />
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。<br />
## 题目要求
- 100.0 < x < 100.0
- 231 <= n <= 231-1
- 104 <= xn <= 104
## 测试样例
输入：x = 2.00000, n = 10 <br />
输出：1024.00000 <br />

输入：x = 2.10000, n = 3 <br />
输出：9.26100 <br />

输入：x = 2.00000, n = -2 <br />
输出：0.25000 <br />
解释：2-2 = 1/22 = 1/4 = 0.25 <br />
# 我的思路
简单的快速幂。
```java
ans = 1;
base = x;
for (int i = n; i > 0; i /= 2) {
    if (i %2 == 1) ans *= base;
    base *= base;
}
```
考虑几个特殊情况:
```java
if (x == 0.0) return 0;
if (x == 1.0 || n == 1) return x;
if (n == 0) return 1;
```
对于 n=0 的处理是 n*=-1，但是 int 的下限绝对值比上限绝对值大 1，所以设置超限标志位，如果 *(-1) 后 n 还是 <0，那么就代表超限，+1 后再 *(-1)。
```java
boolean overrunFlag = false;
n *= -1;
if (n < 0) {
    n += 1;
    n *= -1;
    overrunFlag = true;
}
```
# 官方题解
// TODO
```java
//递归快速幂
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}

//迭代快速幂
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }
}
```