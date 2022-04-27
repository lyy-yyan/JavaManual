package com.lyy.base.testStream;

import com.lyy.base.testCopy.Subject;
import com.lyy.base.testCopy.Student;

import java.util.Optional;

public class TestOptional {
    //一般认知下
//    public Integer getScore(Student student) {
//        if (student != null) {
//            Subject subject = student.getSubject();
//            if (subject != null) {
//                return subject.getScore();
//            }
//        }
//        return null;
//    }

    //函数式下
    public Integer getScore(Student student) {
        return Optional.ofNullable(student)
                .map(Student::getSubject)
                .map(Subject::getScore)
                .orElse(null);
    }
}
