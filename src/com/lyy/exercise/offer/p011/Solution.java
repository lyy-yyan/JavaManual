package com.lyy.exercise.offer.p011;
public class Solution {
    //个人思路：只要有数字＜前一个数字，那么这个数字就是最小的，是旋转一次前的第一个数字
//    public int minArray(int[] numbers) {
//        for (int i = 0; i < numbers.length-1; i++) {
//            if (numbers[i] > numbers[i+1]) {
//                return numbers[i+1];
//            }
//        }
//        return numbers[0];
//    }

    //二分查找（自写）
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;//因为已经存在比min小的数，所以连mid也舍弃
            }else {
                right --;
            }
        }
        return numbers[left];
    }

}
