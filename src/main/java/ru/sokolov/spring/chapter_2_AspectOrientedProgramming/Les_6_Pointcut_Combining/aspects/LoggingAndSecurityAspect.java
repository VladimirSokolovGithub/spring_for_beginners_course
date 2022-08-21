package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_6_Pointcut_Combining.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAndSecurityAspect {

    //Pointcut-ы

//    @Pointcut("execution(* ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_6_Pointcut_Combining.UniLibrary.get*())")
//    private void allGetMethodsFromUniLibrary() {
//    }
//
//    @Pointcut("execution(* ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_6_Pointcut_Combining.UniLibrary.return*()))")
//    private void allReturnMethodsFromUniLibrary() {
//    }

    //Теперь у нас встает такая задача. Нужно чтобы при вызове всех get методов и при вызове всех return
    // методов, нам нужно чтобы работала еще одна сквозная логика, например записывался еще Log#3.
    // Для этого мы можем создать Pointcut, который будет комбинацией нашего первого и второго Pointcut-ов.
    // Для этой комбинации мы будем использовать логический оператор.

//    @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
//    private void allGetAndReturnMethodsFromUniLibrary() {
//    }


    //Advice-ы

//    @Before("allGetMethodsFromUniLibrary()")
//    public void beforeGetLoggingAdvice() {
//        System.out.println("beforeGetLoggingAdvice: writing Log #1");
//    }
//
//    @Before("allReturnMethodsFromUniLibrary()")
//    public void beforeReturnLoggingAdvice() {
//        System.out.println("beforeReturnLoggingAdvice: writing Log #2");
//    }
//
//    @Before("allGetAndReturnMethodsFromUniLibrary()")
//    public void beforeGetAndReturnLoggingAdvice() {
//        System.out.println("beforeGetAndReturnLoggingAdvice: writing Log #3");
//    }

    //Создадим Pointcut, который будет подходить для всех методов класса UniLibrary, кроме метода
    // returnMagazine().

    @Pointcut("execution(* ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_6_Pointcut_Combining.UniLibrary.*(..))")
    private void allMethodsFromUniLibrary() {
    }

    //Теперь создадим Pointcut, который подходит только для метода returnMagazine().

    @Pointcut("execution(public void ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_6_Pointcut_Combining.UniLibrary.returnMagazine())")
    private void returnMagazineFromUniLibrary() {
    }

    //Теперь мы создадим Pointcut, который удовлетворяет первому Pointcut expression, но не
    // удовлетворяет второму Pointcut expression.

    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUniLibrary()")
    private void allMethodsExceptReturnMagazineFromUniLibrary() {
    }

    @Before("allMethodsExceptReturnMagazineFromUniLibrary()")
    public void beforeallMethodsExceptReturnMagazineAdvice() {
        System.out.println("beforeallMethodsExceptReturnMagazineAdvice: Log # 10");
    }

}


