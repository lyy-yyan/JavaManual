package com.lyy.base.testStream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StringOperate {

    public static void main(String[] args) {
        String string = "abcde";
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("bilibili");
        list.add("of");
        list.add("codesheep");
        list.add("5");
        list.add("at");
        list.add("BILIBILI");
        list.add("codesheep");
        list.add("23");
        list.add("CHEERS");
        list.add("6");
        System.out.println(list);

        String result = list.stream()// 首先将列表转化为Stream流
                .filter( i -> !isNum(i) )// 首先筛选出字母型字符串
                .filter( i -> i.length() >= 5 )// 其次筛选出长度>=5的字符串
                .map( i -> i.toLowerCase() )// 字符串统一转小写
                .distinct()                 // 去重操作来一下
                .sorted( Comparator.naturalOrder() ) // 字符串排序来一下
                .collect( Collectors.joining("❤") ); // 连词成句来一下，完美！
        System.out.println(result);

    }

    public static Boolean isNum( String str ) {
        for( int i=0; i<str.length(); i++ ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
