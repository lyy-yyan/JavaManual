package homework;

/*
S的最大长度为26，其中没有重复的字符。
T的最大长度为200，其中最多有1个字符未出现在S中。
S和T只包含小写字符。
测试样例：
输入:
cba
abcd
输出:
cbad
dcba
cdba
cbda
 */

import java.lang.reflect.Array;
import java.util.*;

public class Homework_1125_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S, T;
        S = in.nextLine();
        T = in.nextLine();

//        T_sortBy_S(S, T);

        Homework_1125_02 ob = new Homework_1125_02();
        String ansStr = ob.customSortString(S, T);

        in.close();
    }

    //大佬的答案重写
    public String customSortString (String S, String T) {
        //根据S建立map
        StringBuilder ansStr = new StringBuilder();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), i);
        }

        //T转换为字符数组
        Character[] charT = new Character[T.length()];
        for (int i = 0; i < T.length(); i++) {
            charT[i] = T.charAt(i);
        }

        //重写Arrays.sort()函数
        Arrays.sort(charT, new Comparator<Character>() {
            @Override
            public int compare(Character arg0, Character arg1) {
                //如果map里有arg0,则得到其V，如果没有则为默认值0
                int value0 = map.getOrDefault(arg0, 26);
                int value1 = map.getOrDefault(arg1, 26);
                //比较value0与value1的大小
                return value0 - value1;
            }
        });

        //返回答案
        for (int i = 0; i < charT.length; i++) {
            ansStr.append(charT[i]);
        }
        return ansStr.toString();
    }


    public static void T_sortBy_S (String S, String T) {
        int[] indexS = new int[26];
        int[] indexT = new int[200];

        //初始化
        for (int i = 0; i < indexS.length; i++) {
            indexS[i] = 0;
        }
        for (int i = 0; i < indexT.length; i++) {
            indexT[i] = 0;
        }

        //为S编号
        for (int i = 0; i < S.length(); i++) {
            indexS[i] = i+1;
        }
        
        //根据S为T对应编号
        for (int iOfT = 0; iOfT < T.length(); iOfT++) {
            for (int iOfS = 0; iOfS < S.length(); iOfS++) {
                if (T.charAt(iOfT) == S.charAt(iOfS)) {
                    indexT[iOfT] = indexS[iOfS];
                }
            }
        }
        //记录indexT[iOfT]=0的符号
        char is0Str = 'n';
        for (int i = 0; i < T.length(); i++) {
            if (indexT[i] == 0) {
                is0Str = T.charAt(i);
            }
        }
        //对indexT排序
        Arrays.sort(indexT, 0, T.length());
        //根据S输出T
        //先找出indexT中有几个非0
        int countIsNot0_OfIndexT = 0;
        for (int i = 0; i < indexT.length; i++) {
            if (indexT[i] > 0) {
                countIsNot0_OfIndexT ++;
            }
        }
        //有n个非0就有n+1种输出，StringBuffer中有直接插入字符的方法，下面有转换
        StringBuffer SB = new StringBuffer();
        for (int i = 0; i < indexT.length; i++) {
            if (indexT[i] > 0) {
                SB.append(S.charAt(indexT[i]-1));
            }
        }
        StringBuffer outputSB = new StringBuffer();
        for (int i = 0; i < countIsNot0_OfIndexT+1; i++) {
            outputSB.setLength(0);//清空outputSB
            outputSB.append(SB);
            //重新插入并输出
            outputSB.insert(i, is0Str);
            System.out.println(outputSB);
        }
    }
}

