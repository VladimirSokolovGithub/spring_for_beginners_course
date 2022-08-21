package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_8_Join_Point.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_8_Join_Point.Book;

@Component
@Aspect
@Order(10)
public class LoggingAspect {

    //Прописывая JoinPoint в параметре Advice метода, мы получаем с помощью него информацию о сигнатуре
    // метода, благодаря которому этот Advice срабатывает и информацию о параметрах этого метода.

    @Before("ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_8_Join_Point.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint){

        //получаем из JoinPoint сигнатуру метода
        MethodSignature methodSignature =  (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature = " + methodSignature);

        //получаем из methodSignature наш метод
        System.out.println("methodSignature.getMethod() = " + methodSignature.getMethod());

        //получаем из methodSignature ReturnType нашего метода
        System.out.println("methodSignature.getReturnType() = " + methodSignature.getReturnType());

        //получаем из methodSignature Name нашего метода
        System.out.println("methodSignature.getName() = " + methodSignature.getName());


        //Теперь поработаем с параметрами методов add.
        // Для метода addBook так как у него есть параметры, будем выводить параметры, а для
        // метода addMagazine() не будем выводить параметры даже если бы они у него были.

        if (methodSignature.getName().equals("addBook")) {
            Object[] arguments = joinPoint.getArgs();
            for (Object obj : arguments){
                if (obj instanceof Book){
                    Book myBook = (Book) obj;
                    System.out.println("Информация о книге: название книги - " + myBook.getName() +
                            ", автор - " + myBook.getAuthor() +
                            ", год издания - " + myBook.getYearOfPublication());
                } else if (obj instanceof String) {
                    System.out.println("Книгу в библиотеку добавляет " + obj);
                }
            }
        }

        System.out.println("beforeGetLoggingAdvice: Логирование попытки получить книгу/журнал");
        System.out.println("---------------------------------------------------------------");
    }

}
