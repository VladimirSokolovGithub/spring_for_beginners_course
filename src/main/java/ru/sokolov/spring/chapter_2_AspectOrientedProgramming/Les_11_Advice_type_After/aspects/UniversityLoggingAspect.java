package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_11_Advice_type_After.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UniversityLoggingAspect {

    //С помощью @AfterThrowing Advice-а нам дается возможность что-либо сделать перед тем, как
    // исключение из метода getStudents перепрыгнет в метод main. Но в AfterThrowing Advice мы
    // ничего не можем сделать для того что бы исключение не попало в метод main. Мы не можем его
    // обрабатывать в Advice методе, оно все равно попадет в метод main.


//    @AfterThrowing("execution(* getStudents())")
//    public void afterThrowingGetStudentsLoggingAdvice(){
//        System.out.println("afterThrowingGetStudentsLoggingAdvice: логируем выброс исключения");
//    }


    //С помощью @AfterThrowing Advice-а мы можем получить информацию об Exception-е, который был
    // выброшен в target методе. Для этого нужно добавить второй параметр в аннотацию @AfterThrowing.
    // Этот параметр throwing = "exception". Так же мы должны в параметр Advice метода добавить
    // тип Throwable и название его переменной exception должно совпадать.
    // Throwable (переводится как, то что можно выбросить) это клас родитель для классов Exception и
    // Error.


//    @AfterThrowing(pointcut = "execution(* getStudents())", throwing = "exception")
//    public void afterThrowingGetStudentsLoggingAdvice(Throwable exception){
//        System.out.println("afterThrowingGetStudentsLoggingAdvice: логируем выброс " +
//                "исключения " + exception);
//    }

    @After("execution(* getStudents())")
    public void afterGetStudentsLoggingAdvice(){
        System.out.println("afterGetStudentsLoggingAdvice: нормальное окончание работы " +
                "метода или выброс исключения");
    }


}
