package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_8_Join_Point.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(30)
public class ExceptionHandlingAspect {

    @Before("ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_8_Join_Point.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddExceptionHandlingAdvice(){
        System.out.println("beforeGetExceptionHandlingAdvice: ловим/обрабатываем исключения " +
                "при попытке получить книгу/журнал");
        System.out.println("---------------------------------------------------------------");

    }

}
