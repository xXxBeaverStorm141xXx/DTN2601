package com.vti.backend;

import com.vti.entity.Student;

public class Exercise4 {
    public void Question1(){
        Student student1 = new Student("pptx", "USUK");
        student1.setScore(3f);
        Student student2 = new Student("word", "CND");
        student2.setScore(5f);
        Student student3 = new Student("excel", "TW");
        student3.setScore(7f);

        System.out.println(student1.toString());
        System.out.println(student2);
        System.out.println(student3);
    }
}
