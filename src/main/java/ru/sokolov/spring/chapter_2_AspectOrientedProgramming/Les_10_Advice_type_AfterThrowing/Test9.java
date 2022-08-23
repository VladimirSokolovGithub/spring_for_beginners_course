package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_10_Advice_type_AfterThrowing;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class Test9 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig9.class);

        University university = context.getBean("university", University.class);
        university.addStudents();
        try {
            List<Student> studentList = university.getStudents();
            System.out.println(studentList);
        }
        catch (Exception e){
            System.out.println("Было поймано исключение " + e);
        }



        context.close();
    }
}
