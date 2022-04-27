package com.lyy.offer;

import com.lyy.offer.p012.Solution;

public class Main {
    public static void main(String[] args) {
        Solution ob = new Solution();
        //p012
        char[][] board1 = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word1 = "ABCCED";
        char[][] board2 = {{'a','b'},{'c','d'}};
        String word2 = "abcd";
        char[][] board3 = {{'a'}};
        String word3 = "a";
        char[][] board4 = {{'a'}};
        String word4 = "ab";
        char[][] board5 = {{'a','b'}};
        String word5 = "ba";
//        System.out.println(word1.charAt(1) == board1[0][1] ? true:false);
        System.out.print("true ");
        System.out.println(ob.exist(board1, word1));

        System.out.print("false ");
        System.out.println(ob.exist(board2, word2));

        System.out.print("true ");
        System.out.println(ob.exist(board3, word3));

        System.out.print("false ");
        System.out.println(ob.exist(board4, word4));

        System.out.print("true ");
        System.out.println(ob.exist(board5, word5));

        //p011
//        int[] input1 = {3,4,5,1,2};
//        int[] input2 = {2,2,2,0,1};
//        System.out.println(ob.minArray(input1));
//        System.out.println(ob.minArray(input2));
    }
}
