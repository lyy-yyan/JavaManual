package homework;

import java.util.Scanner;

/*
测试样例
10 3
1 9 2 60 8 17 11 4 5 14
1 5 9
 */

public class Homework_1009_01 {
    public static void main(String[] args) {
        int[] arrayStudent = new int[2*(int)Math.pow(10,6)];
        String str;
        int n, m;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();

        for(int i = 0; i < n; i++){
            arrayStudent[i] = in.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int ask = in.nextInt();
            System.out.println(arrayStudent[ask-1]);
        }
        in.close();
    }
}
