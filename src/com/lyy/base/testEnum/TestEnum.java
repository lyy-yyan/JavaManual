package com.lyy.base.testEnum;

//可以静态导入枚举类
import static com.lyy.base.testEnum.Family.*;

public class TestEnum {
    public static void main(String[] args) {
        Family s = Family.FATHER;
        System.out.println(s);

        //ordinal()方法表示enum常量的声明顺序，以及values()方法显示顺序的值，.values()直接取出的值相当于数组
        for (Family family : Family.values()) {
            System.out.println(family + ", ordinal: " + family.ordinal());
        }

        //静态导入枚举类后则可直接使用常量
        Family family = MOTHER;
    }
}
