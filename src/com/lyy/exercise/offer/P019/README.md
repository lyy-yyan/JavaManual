# 剑指 Offer 19. 正则表达式匹配
## 题目描述
请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。<br />
在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。<br />

来源：力扣（LeetCode）<br />
链接：https://leetcode.cn/problems/zheng-ze-biao-da-shi-pi-pei-lcof <br />
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。<br />

## 题目要求
- s 可能为空，且只包含从 a-z 的小写字母。<br />
- p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。<br />
## 测试样例
示例1:<br />
输入:<br />
s = "aa" <br />
p = "a" <br />
输出: false <br />
解释: "a" 无法匹配 "aa" 整个字符串。<br />

示例2: <br />
输入: <br />
s = "aa" <br />
p = "a*" <br />
输出: true <br />
解释:因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。 <br />

示例3: <br />
输入: <br />
s = "ab" <br />
p = ".*" <br />
输出: true <br />
解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。 <br />

示例4: <br />
输入: <br />
s = "aab" <br />
p = "c*a*b" <br />
输出: true <br />
解释:因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。 <br />

示例5: <br />
输入: <br />
s = "mississippi" <br />
p = "mis*is*p*." <br />
输出: false <br />
# 我的思路
个人思路：递归方法
对于当前字符匹配，只有字符相同和字符与‘.’匹配以及不匹，也就是匹配与不匹配两种情况。
下一步匹配，仅需看下一个字符是不是‘*’，
如果不是‘*’，那么这当前必须匹配成功才能前进下一步，
如果是‘*’，则下一步可以考虑当且匹配且继续匹配‘*’或者直接跳过‘*’。
# 官方题解
动态规划
```java
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
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
```