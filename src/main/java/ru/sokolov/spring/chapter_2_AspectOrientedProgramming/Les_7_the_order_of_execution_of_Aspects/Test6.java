package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_7_the_order_of_execution_of_Aspects;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test6 {
    public static void main(String[] args) {

        //(см.класс LoggingAndSecurityAspect и package aspects)
        //Если нам необходимо чтобы соблюдался порядок выполнения Advice-ов, то нужно разместить все
        // Advice-ы, которые могут выполняться для одного бизнес метода, в разные Аспекты (Aspect классы).
        // А сами Aspect классы мы пометим аннотацией @Order. Так же необходимо выделить в отдельный класс
        // наш Pointcut - метод и изменить его модификатор доступа с private на public.
        // Так же создадим еще один класс ExceptionHandlingAspect
        // Далее с помощью аннотации @Order(1) пометим все наши Aspect классы и в скобках укажим
        // порядок выполнения наших Advice-ов.


        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig6.class);

       UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);

        uniLibrary.getBook();
        uniLibrary.getMagazine();


        context.close();
    }
}
