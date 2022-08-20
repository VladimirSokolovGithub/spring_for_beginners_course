package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_3_Pointcut_expression_Part1.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect2 {
    //Здесь мы создаём Advice - beforeAddBookAdvice

//    @Before("execution(public void getBook())")
//    public void beforeAddBookAdvice(){
//        System.out.println("beforeAddBookAdvice: попытка получить книгу. Trying to get a book");
//    }

    //Теперь сделаем так, что бы наш шаблон подходил только для метода getBook() из класса UniLibrary.
    //Для этого после return type модификатора указывается полное имя класса
    // со всеми пакетами и через точку наш метод.

//    @Before("execution(public void ru.sokolov.spring.chapter_2_AspectOrientedProgramming." +
//            "Les_3_Pointcut_expression_Part1.UniLibrary.getBook())")
//    public void beforeAddBookAdvice(){
//        System.out.println("beforeAddBookAdvice: попытка получить книгу. Trying to get a book");
//    }

    //Допустим что нам нужно сделать так, чтобы под наш шаблон подходили методы с разными именами,
    // но которые начинаются на get. Это всё достигается с помощью wildcards - и в нашем случае
    // мы применим wildcards - "*" звездочку. (см.слайд 2_Pointcut_2).

    @Before("execution(public void get*())")
    public void beforeAddBookAdvice(){
        System.out.println("beforeAddBookAdvice: попытка получить книгу. Trying to get a book");
    }

    //Теперь поработаем с методом returnBook(), создадим ещё один Advice.

//    @Before("execution(public void returnBook())")
//    public void beforeReturnBookAdvice(){
//        System.out.println("beforeReturnBookAdvice: попытка вернуть книгу. Trying to return a book");
//    }

    //Теперь поработаем с методом returnBook() но изменим у него return type на String и используя
    // wildcards - "*" звездочку заменим на неё наш return type в шаблоне Advice.

//    @Before("execution(public * returnBook())")
//    public void beforeReturnBookAdvice(){
//        System.out.println("beforeReturnBookAdvice: попытка вернуть книгу. Trying to return a book");
//    }

    //Если мы хотим, чтобы под наш Advice beforeReturnBookAdvice подходили методы returnBook()
    // с любым access modifier, то мы можем просто убрать access modifier public из нашего шаблона.

    @Before("execution(* returnBook())")
    public void beforeReturnBookAdvice(){
        System.out.println("beforeReturnBookAdvice: попытка вернуть книгу. Trying to return a book");
    }

}
