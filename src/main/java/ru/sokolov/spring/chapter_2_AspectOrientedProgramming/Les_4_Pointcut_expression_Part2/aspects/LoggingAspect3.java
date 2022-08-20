package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_4_Pointcut_expression_Part2.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect3 {
    //Создание Advice и Pointcut с параметром
    //Для этого в методе getBook(String) добавим в параметр тип String

//    @Before("execution(public void getBook(String))")
//    public void beforeAddBookAdvice() {
//        System.out.println("beforeAddBookAdvice: попытка получить книгу. Trying to get a book");
//    }

    //Теперь нам нужно сделать так, чтобы под наш шаблон Pointcut подходил любой метод с любым одним
    // параметром. Для этого меняем параметр String на wildcard - *

//    @Before("execution(public void getBook(*))")
//    public void beforeAddBookAdvice() {
//        System.out.println("beforeAddBookAdvice: попытка получить книгу. Trying to get a book");
//    }

    //Теперь добавим метод getMagazine(int a) с параметром int в класс UniLibrary2 и поменяем наш
    // Pointcut так, чтобы вызывался любой метод с любым параметром.

//    @Before("execution(public void *(*))")
//    public void beforeAddBookAdvice() {
//        System.out.println("beforeAddBookAdvice: попытка получить книгу. Trying to get a book");
//    }

    //Если нам нужно чтобы под наш Pointcut подходил любой метод с любым количеством параметров,
    // любых типов, то в скобках вместо звёздочки мы ставим две точки ".."

//    @Before("execution(public void *(..))")
//    public void beforeAddBookAdvice() {
//        System.out.println("beforeAddBookAdvice: попытка получить книгу. Trying to get a book");
//    }

    //Рассмотрим пример, когда в параметры нашего метода getBook() подставляется объект класса,
    // который мы создали сами. В параметре при этом мы должны писать полное имя класса включая пакеты.

    @Before("execution(public void getBook(ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_4_Pointcut_expression_Part2.Book))")
    public void beforeAddBookAdvice() {
        System.out.println("beforeAddBookAdvice: попытка получить книгу. Trying to get a book");
    }


}


