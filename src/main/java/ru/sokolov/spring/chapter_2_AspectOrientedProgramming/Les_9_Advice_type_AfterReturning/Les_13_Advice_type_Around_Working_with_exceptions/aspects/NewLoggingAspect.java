package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_9_Advice_type_AfterReturning.Les_13_Advice_type_Around_Working_with_exceptions.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {

    //С помощью Around Advice мы можем обрабатывать исключения в отличии от AfterThrowing Advice.
    // Если было выброшено исключение, то оно выбросилось в блоке try и targetMethodResult не успел
    // принять значение, так как target method returnBook() значение нам не вернул. Следовательно,
    // targetMethodResult вернёт null. Но так как мы не хотим чтобы targetMethodResult возвращал
    // null, мы в блоке catch сами можем прописать какое-то значение переменной targetMethodResult.

    //Так же следует отметить что если мы таким образом будем обрабатывать исключения, то в методе
    // main (Test12) при вызове метода returnBook() никогда никто не узнает что было выброшено
    // исключение. Поэтому не всегда нужно обрабатывать такие исключения, а делать проброс этого
    // дальше по стеку.

    //Это не очень хорошее решение, оно демонстрирует нам, что мы можем внутри Around Advice
    // обрабатывать исключения.

//    @Around("execution(public String returnBook())")
//    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку пытаются вернуть книгу");
//
//        //Вручную запустим наш target method returnBook() -  с помощью proceedingJoinPoint.proceed();
//        Object targetMethodResult = null;
//        try {
//            targetMethodResult =  proceedingJoinPoint.proceed();
//        }
//        catch (Exception e){
//            System.out.println("aroundReturnBookLoggingAdvice: было поймано исключение " + e);
//            targetMethodResult = "Неизвестное название книги";
//        }
//
//        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку успешно вернули книгу");
//
//        return targetMethodResult;
//    }



    //Далее проброс исключения наверх в main метод.
    //Пишем в лог, что выбросилось исключение и бросаем его дальше на верх.

    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку пытаются вернуть книгу");

        //Вручную запустим наш target method returnBook() -  с помощью proceedingJoinPoint.proceed();
        Object targetMethodResult = null;
        try {
            targetMethodResult =  proceedingJoinPoint.proceed();
        }
        catch (Exception e){
            System.out.println("aroundReturnBookLoggingAdvice: исключение " + e + " было залогировано");
            throw e; //проброс исключения наверх в main метод.
        }

        //При пробросе исключения на верх в main метод, ниже идущие строчки кода не сработают
        // так как при получении этого exception main методом он прекратит свою работу.
        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку успешно вернули книгу");

        return targetMethodResult;
    }


}
