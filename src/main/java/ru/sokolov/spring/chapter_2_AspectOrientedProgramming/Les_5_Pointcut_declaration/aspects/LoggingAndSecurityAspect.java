package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_5_Pointcut_declaration.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAndSecurityAspect {

//    @Before("execution(* get*())")
//    public void beforeGetLoggingAdvice() {
//        System.out.println("beforeGetLoggingAdvice: попытка получить книгу/журнал. Trying to get a book or magazine");
//    }

    //Добавим в наш Aspect класс ещё один Advice securityCheck - он будет отвечать за проверку прав.

//    @Before("execution(* get*())")
//    public void beforeGetSecurityAdvice() {
//        System.out.println("beforeGetSecurityAdvice: проверка прав на получение книги/журнала");
//    }

    //Что мы видим выше, то что это copy paste Poincut-ов. Это нехорошо.
    //Решение этого в том, что мы можем объявлять Poincut-ы как отдельную сущность и применять их
    // к множеству Advice-ов. И если нам нужно будет менять Poincut выражение мы будем менять его один
    // раз в одном месте.

    @Pointcut("execution(* get*())")
    private void allGetMethods(){}

    @Before("allGetMethods()")
    public void beforeGetLoggingAdvice() {
        System.out.println("beforeGetLoggingAdvice: попытка получить книгу/журнал. Trying to get a book or magazine");
    }

    //Добавим в наш Aspect класс ещё один Advice securityCheck - он будет отвечать за проверку прав.

    @Before("allGetMethods()")
    public void beforeGetSecurityAdvice() {
        System.out.println("beforeGetSecurityAdvice: проверка прав на получение книги/журнала");
    }


}


