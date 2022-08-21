package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_6_Pointcut_Combining;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test5 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig5.class);

        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);

        uniLibrary.getBook();
        uniLibrary.returnMagazine();
        uniLibrary.addBook();

        context.close();
    }
}
