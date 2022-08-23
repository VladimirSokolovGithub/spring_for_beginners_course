package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_9_Advice_type_AfterReturning.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_9_Advice_type_AfterReturning.Student;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {

    @Before("execution(* getStudents())")
    public void beforeGetStudentsLoggingAdvice(){
        System.out.println("beforeGetStudentsLoggingAdvice: логируем получение списка студентов " +
                "перед методом getStudents");
    }

//    @AfterReturning("execution(* getStudents())")
//    public void afterReturningGetStudentsLoggingAdvice(){
//        System.out.println("afterReturningGetStudentsLoggingAdvice: логируем получение списка студентов " +
//                "после работы метода getStudents");
//    }

    //У Advice-а @AfterReturning есть одна очень мощная функциональность. Благодаря тому, что этот
    // Advice работает после target метода, то он может перехватывать результат работы метода ( т.е. его
    // return) и делать с этим результатом определенную работу.
    //Для примера сейчас мы изменим результат метода getStudents с помощью Advice-а @AfterReturning.
    // Перед этим в параметры аннотации @AfterReturning мы добавим ещё один элемент. Когда элементов
    // становится больше одного мы должны писать имя этого элемента и его значение. Присвоим имя
    // pointcut нашему значению "execution(* getStudents())" и добавим имя returning и добавим ему
    // значение "students". Таким образом returning это тот результат, который будет возвращать метод
    // подходящий под наш pointcut. Далее в параметры нашего Advice метода мы должны прописать тот
    // тип, который возвращает метод getStudents, а getStudents возвращает у нас List<Student> students.
    // При этом значение параметра returning аннотации @AfterReturning должно совпадать со значением
    // параметра нашего Advice метода. Далее с нашим этим результатом мы можем проделывать нужные нам
    // операции.

    @AfterReturning(pointcut = "execution(* getStudents())", returning = "students")
    public void afterReturningGetStudentsLoggingAdvice(List<Student> students){
        Student firstStudent = students.get(0);

        String nameSurname = firstStudent.getNameSurname();
        nameSurname = "Mr. " + nameSurname;
        firstStudent.setNameSurname(nameSurname);

        double avgGrade = firstStudent.getAvgGrade();
        avgGrade = avgGrade+1;
        firstStudent.setAvgGrade(avgGrade);

        System.out.println("afterReturningGetStudentsLoggingAdvice: логируем получение списка студентов " +
                "после работы метода getStudents");
    }
}
