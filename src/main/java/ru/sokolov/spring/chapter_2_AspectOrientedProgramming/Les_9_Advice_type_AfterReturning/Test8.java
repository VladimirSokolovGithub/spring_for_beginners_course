package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_9_Advice_type_AfterReturning;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test8 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig8.class);

        University university = context.getBean("university", University.class);
        university.addStudents();
        List<Student> studentList = university.getStudents();
        System.out.println(studentList);


        context.close();
    }
}
