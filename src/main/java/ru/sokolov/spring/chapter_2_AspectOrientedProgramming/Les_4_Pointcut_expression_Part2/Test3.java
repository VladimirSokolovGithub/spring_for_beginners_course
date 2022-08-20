package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_4_Pointcut_expression_Part2;

//На этом уроке поговорим о параметрах метода при написании Pointcut для Advice в Aspect классах.

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig3.class);

        UniLibrary2 uniLibrary2 = context.getBean("uniLibrary2", UniLibrary2.class);
        Book book = context.getBean("book", Book.class);

        uniLibrary2.getBook(book);

//        uniLibrary2.getMagazine(18);



        context.close();
    }


}
