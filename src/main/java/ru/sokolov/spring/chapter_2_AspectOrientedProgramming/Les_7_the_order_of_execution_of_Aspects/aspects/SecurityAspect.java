package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_7_the_order_of_execution_of_Aspects.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(20)
public class SecurityAspect {

    @Before("ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_7_the_order_of_execution_of_Aspects.aspects.MyPointcuts.allGetMethods()")
    public void beforeGetSecurityAdvice(){
        System.out.println("beforeGetSecurityAdvice: Проверка прав на получение книги/журнала");
    }

}
