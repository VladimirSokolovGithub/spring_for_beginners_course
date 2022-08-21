package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_8_Join_Point.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(20)
public class SecurityAspect {

    @Before("ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_8_Join_Point.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddSecurityAdvice(){
        System.out.println("beforeGetSecurityAdvice: Проверка прав на получение книги/журнала");
        System.out.println("---------------------------------------------------------------");
    }

}
