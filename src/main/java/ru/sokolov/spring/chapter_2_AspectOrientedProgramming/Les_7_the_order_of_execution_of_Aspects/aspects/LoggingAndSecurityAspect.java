package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_7_the_order_of_execution_of_Aspects.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAndSecurityAspect {

    //Если нам необходимо чтобы соблюдался порядок выполнения Advice-ов, то нужно разместить все
    // Advice-ы, которые могут выполняться для одного бизнес метода, в разные Аспекты (Aspect классы).
    // А сами Aspect классы мы пометим аннотацией @Order. Так же необходимо выделить в отдельный класс
    // наш Pointcut - метод и изменить его модификатор доступа с private на public.
    // Так же создадим еще один класс ExceptionHandlingAspect
    // Далее с помощью аннотации @Order(1) пометим все наши Aspect классы и в скобках укажим
    // порядок выполнения наших Advice-ов.

    //Pointcut-ы

//    @Pointcut("execution(* get*())")
//    private void allGetMethods(){
//    }

    //Advice-ы

//    @Before("allGetMethods()")
//    public void beforeGetLoggingAdvice(){
//        System.out.println("beforeGetLoggingAdvice: Логирование попытки получить книгу/журнал");
//    }

//    @Before("allGetMethods()")
//    public void beforeGetSecurityAdvice(){
//        System.out.println("beforeGetSecurityAdvice: Проверка прав на получение книги/журнала");
//    }

}


