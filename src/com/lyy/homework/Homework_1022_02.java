package homework;

import java.util.Scanner;

/*
测试样例
ailkmno
ilkm
1

abbbdhucd
hucd
5

skahdk
aaa
-1

 */

public class Homework_1022_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        System.out.println(func_BF(str1, str2));
        in.close();
    }

    //BF算法
    public static int func_BF(String str1, String str2) {
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        int i = 0;
        int j;
        while(i < str1.length()-1) {
            j = 0;
            while(c1[i] == c2[j] && j< str2.length() - 1) {
                i ++;
                j ++;
            }
            if(j == str2.length()-1) {
                return i - str2.length() + 1;

            }
            i = i - j + 1;

        }
        return -1;
    }
}




