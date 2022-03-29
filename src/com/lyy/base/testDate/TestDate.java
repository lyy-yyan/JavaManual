package com.lyy.base.testDate;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class TestDate {
    public static void main(String[] args) {
        LocalDateTime rightNow = LocalDateTime.now();
        System.out.println( "当前时刻：" + rightNow );
        System.out.println( "当前年份：" + rightNow.getYear() );
        System.out.println( "当前月份：" + rightNow.getMonth() );
        System.out.println( "当前日份：" + rightNow.getDayOfMonth() );
        System.out.println( "当前时：" + rightNow.getHour() );
        System.out.println( "当前分：" + rightNow.getMinute() );
        System.out.println( "当前秒：" + rightNow.getSecond() );

        //构造指定时间
        LocalDateTime beforeDate = LocalDateTime.of(2019, Month.APRIL, 12, 9, 21, 32);
        System.out.println("beforeDate: " + beforeDate);

        //修改日期
        beforeDate = beforeDate.minusYears(2);
        System.out.println(beforeDate);

        beforeDate = beforeDate.plusMonths(3);
        System.out.println(beforeDate);

        beforeDate = beforeDate.withYear(2008);
        System.out.println(beforeDate);

        beforeDate = beforeDate.withHour(13);
        System.out.println(beforeDate);

        //格式化日期
        String result = rightNow.format(DateTimeFormatter.ofPattern("yyyy//MM//dd"));
        System.out.println(result);
        String result1 = rightNow.format( DateTimeFormatter.ISO_DATE );
        String result2 = rightNow.format( DateTimeFormatter.BASIC_ISO_DATE );
        String result3 = rightNow.format( DateTimeFormatter.ofPattern("yyyy/MM/dd") );
        System.out.println("格式化后的日期(基本样式一举例)：" + result1);
        System.out.println("格式化后的日期(基本样式二举例)：" + result2);
        System.out.println("格式化后的日期(自定义样式举例)：" + result3);

        //时间反解析
        LocalDateTime time = LocalDateTime.parse("2002--01--02 11:21", DateTimeFormatter.ofPattern("yyyy--MM--dd HH:mm"));
        System.out.println("字符串反解析后的时间为：" + time);
    }
}
