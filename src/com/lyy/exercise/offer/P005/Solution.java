package exercise.leetcode.offer.P005;

import java.util.Scanner;

/*
测试样例
输入："We are happy."
输出："We%20are%20happy."
 */

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please input s, the following function converts all Spaces to %20.");
        String s = in.nextLine();
        Solution ob = new Solution();
        String ans = ob.replaceSpace(s);
        System.out.println(ans);
        in.close();
    }

    public String replaceSpace(String s) {
        char[] charS = new char[s.length()*3];
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                charS[size++] = s.charAt(i);
            }else {
                charS[size++] = '%';
                charS[size++] = '2';
                charS[size++] = '0';
            }
        }
//        String ans = new String();
//        for (int i = 0; i < charS.length; i++) {
//            if (charS[i] != null) {
//                ans += charS[i];
//            }
//        }
        //将一个字符数组转换为String，可以在String构造函数处直接转换，如下：
        //String ans = new String(char数组, 开始位置, 长度);
        String ans = new String(charS, 0, size);
        return ans;
    }
}
