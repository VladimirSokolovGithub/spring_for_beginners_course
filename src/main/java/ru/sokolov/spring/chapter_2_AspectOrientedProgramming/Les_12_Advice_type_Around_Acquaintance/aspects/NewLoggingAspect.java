package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_12_Advice_type_Around_Acquaintance.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {

    //В данном случае наш target method returnBook() не отработал. Дело в том, что если мы используем
    // Around Advice, то мы берём на себя ответственность самим запускать target method. Разберемся
    // как это всё работает и правильно напишем Around Advice метод.

//    @Around("execution(public String returnBook())")
//    public void aroundReturnBookLoggingAdvice() {
//        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку возвращают книгу");
//    }

    //И так. В параметр Around Advice метод принимает не просто Join Point, а ProceedingJoinPoint.
    // ProceedingJoinPoint - означает связь с target method-ом. Т.е. мы будем использовать
    // ProceedingJoinPoint, что бы запустить наш target method. Наш target method имеет
    // return type String. Получается, что если мы будем запускать внутри Around Advice метода наш
    // target method, то наш Around Advice тоже должен возвращать String.
    //Вручную запустим наш target method returnBook() -  с помощью proceedingJoinPoint.proceed();
    // метод proceed() выбрасывает исключение Throwable, поэтому добавим его в сигнатуру метода.
    // Далее мы должны вернуть результат proceed() метода, а его результат это Object. Поэтому создадим
    // переменную targetMethodResult типа Object и присвоим ей возвращаемое proceeding методом значение.
    // Из-за того что метод proceed() возвращает Object, то чаще всего return type Around Advice метода
    // - это Object, поэтому заменим String на Object.
    // И вернем этот результат

    // С помощью ProceedingJoinPoint, так же как и с помощью обычного Join Point мы можем получить
    //доступ к сигнатуре метода и параметрам target метода.

//    @Around("execution(public String returnBook())")
//    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку пытаются вернуть книгу");
//
//        //Вручную запустим наш target method returnBook() -  с помощью proceedingJoinPoint.proceed();
//        Object targetMethodResult =  proceedingJoinPoint.proceed();
//
//        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку успешно вернули книгу");
//        return targetMethodResult;
//    }

    //Так же рассмотрим ещё один пример работы Around Advice метода и засечём время работы метода
    // returnBook().

    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку пытаются вернуть книгу");

        long begin = System.currentTimeMillis(); //засекаем время

        //Вручную запустим наш target method returnBook() -  с помощью proceedingJoinPoint.proceed();
        Object targetMethodResult =  proceedingJoinPoint.proceed();

        //так же мы можем изменить результат работы нашего метода returnBook()
        targetMethodResult = "Три толстяка";

        long end = System.currentTimeMillis();

        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку успешно вернули книгу");

        System.out.println("aroundReturnBookLoggingAdvice: метод returnBook()" +
                "выполнил работу за " + (end - begin) + " миллисекунд");

        return targetMethodResult;
    }


}
