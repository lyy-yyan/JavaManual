# 剑指 Offer 03. 数组中重复的数字
## 题目描述
找出数组中重复的数字。<br />
在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。<br />

来源：力扣（LeetCode）<br />
链接：https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof <br />
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。<br />
## 题目要求
- 2 <= n <= 100000
## 测试样例
输入：[2, 3, 1, 0, 2, 5, 3]<br />
输出：2 或 3 <br />
# 官方题解
```java
class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }
}
```