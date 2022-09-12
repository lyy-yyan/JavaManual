# 剑指 Offer 05. 替换空格
## 题目描述
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。<br />

来源：力扣（LeetCode）<br />
链接：https://leetcode.cn/problems/ti-huan-kong-ge-lcof <br />
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。<br />
## 题目要求
- 0 <= s 的长度 <= 10000
## 测试样例
输入：s = "We are happy."<br />
输出："We%20are%20happy."
# 官方题解
```java
class Solution {
    public String replaceSpace(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        return String(array, 0, size);
    }
}
```