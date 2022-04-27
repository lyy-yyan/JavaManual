package homework;

import java.util.Scanner;

/*测试样例：
        3 3
        1 2 3
        4 5 6
        7 8 9
 */
public class Homework_1022_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int M = in.nextInt();
        int N = in.nextInt();
        int[][] array = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = in.nextInt();
            }
        }

        for (int i = 0, j = 0, n = 0; n < M*N; ) {
            System.out.print(array[i][j] + " ");
            n ++;
            if((i+j)%2 == 0){//行列和为偶数
                if(i == 0 && (j+1) < N) {//在第一行,向右
                    j ++;
                }else if (j == (N-1) && (i+1) < M) {//在最后一列，向下
                    i ++;
                }else if ((i-1) >= 0 && (j+1) < N) {
                    i --;
                    j ++;
                }
            }else {//行列和为奇数
                if (j == 0 && (i+1) < M) {//在第一列，向下
                    i ++;
                }else if (i == (M-1) && (j+1) < N) {//在最后一行，向右
                    j ++;
                }else if ((i+1) < M && (j-1) >= 0) {
                    i ++;
                    j --;
                }
            }
        }

        in.close();
    }
}
