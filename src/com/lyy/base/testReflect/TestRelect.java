package com.lyy.base.testReflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRelect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class student = null;
        try {
            student = Class.forName("com.lyy.base.testReflect.Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("---------------------------------------------------------------------------");
        System.out.println("获取对象的所有公共属性");
        Field[] fields = student.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("获取对象所有属性，但不包含继承的");
        Field[] declaredFields = student.getDeclaredFields();
        for (Field df : declaredFields) {
            System.out.println(df);
        }
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("获取对象的所有公共方法");
        Method[] methods = student.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("获取对线所有方法，但不包含继承的");
        Method[] declaredMethods = student.getDeclaredMethods();
        for (Method dm : declaredMethods) {
            System.out.println(dm);
        }
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("获取对象所有的公共构造方法");
        Constructor[] constructors = student.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
        }
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("获取对象所有的构造方法");
        Constructor[] declaredConstructors = student.getDeclaredConstructors();
        for (Constructor dc : declaredConstructors) {
            System.out.println(dc);
        }
        System.out.println("---------------------------------------------------------------------------");

        Class c = Class.forName("com.lyy.base.testReflect.Student");
        Student student1 = (Student)c.newInstance();
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("第一种方法，实例化默认构造方法，调用set赋值");
        student1.setAddress("甘肃张掖");
        System.out.println(student1);
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("第二种方法，取得全部的构造函数，使用构造函数赋值");
        Constructor<Student> constructor = c.getConstructor(String.class, int.class, String.class, String.class);
        Student student2 = (Student)constructor.newInstance("lyy", 22, "三班", "甘肃");
        System.out.println(student2);
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("???获取方法并执行方法???");
        //获取showInfo()方法
        Method show = c.getMethod("showInfo");
        //调用showInfo()方法
        Object object = show.invoke(student2);
        System.out.println("---------------------------------------------------------------------------");
    }
}
