package com.lyy.base.testCopy;

public class Student implements Cloneable{
     private String name;
     private int age;
     private Major major;
     private Subject subject;

     Student() {

     }

     Student(String name, int age, Major major, Subject subject) {
         this.name = name;
         this.age = age;
         this.major = major;
         this.subject = subject;
     }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Major getMajor() {
        return major;
    }

    public Subject getSubject() {
        return subject;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
         Student student = (Student) super.clone();
         student.major = (Major) major.clone();
         return student;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", major=" + major +
                '}';
    }
}
