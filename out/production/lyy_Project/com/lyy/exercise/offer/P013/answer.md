# 剑指 Offer 13. 机器人的运动范围
## 题目描述
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
## 题目要求
- 1 <= n,m <= 100
- 0 <= k <= 20
## 测试样例：
输入：m = 2, n = 3, k = 1
输出：3

输入：m = 3, n = 1, k = 0
输出：1

输入：m = 100, n = 100, k = 20
输出：6117
## 本人代码可优化之处
1. k=0时，答案固定为1，无需再搜索；
2. 利用Queue接口而不是固定queue大小，这样也简化了操作和代码；
3. 隐含优化：其实仅需要向右向下搜索即可；
4. 求一个数各位数之和，而不是两个数，这样的函数泛用性更高。
> 优化前执行用时17 ms，内存消耗41 MB。
> 
> 优化后执行用时5 ms，内存消耗40.6 MB。
# 官方题解
```java
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        Queue<int[]> queue = new LinkedList<>();
        // 向右和向下的方向数组
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        boolean[][] vis = new boolean[m][n];
        queue.offer(new int[]{0, 0});
        vis[0][0] = true;
        int ans = 1;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 2; ++i) {
                int tx = dx[i] + x;
                int ty = dy[i] + y;
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || vis[tx][ty] || get(tx) + get(ty) > k) {
                    continue;
                }
                queue.offer(new int[]{tx, ty});
                vis[tx][ty] = true;
                ans++;
            }
        }
        return ans;
    }

    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
```