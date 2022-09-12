# 剑指 Offer 04. 二维数组中的查找
## 题目描述
在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。<br />

来源：力扣（LeetCode）<br />
链接：https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof <br />
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
## 题目要求
- 0 <= n <= 1000
- 0 <= m <= 1000
## 测试样例
现有矩阵 matrix 如下：<br />
```json
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
```
给定 target = 5，返回 true。<br />
给定 target = 20，返回 false。<br />
# 可优化之处
考虑数组特性：每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
# 官方题解
```java
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;

        for (int i : rows) {
            for (int j : columns) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
```