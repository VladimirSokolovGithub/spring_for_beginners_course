package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_11_Advice_type_After;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class University {

    private List<Student> students = new ArrayList<>();

    public void addStudents() {
        Student st1 = new Student("Vladimir Sokolov", 4, 7.5);
        Student st2 = new Student("Mikhail Ivanov", 2, 8.3);
        Student st3 = new Student("Elena Sidorova", 1, 9.1);

        students.add(st1);
        students.add(st2);
        students.add(st3);
    }

    public List<Student> getStudents (){
        System.out.println("Начало работы метода getStudents");
        System.out.println(students.get(3)); //Закомментировать строку для проверки программы
        System.out.println("Information from method getStudents:");
        System.out.println(students);
        return students;
    }
}
