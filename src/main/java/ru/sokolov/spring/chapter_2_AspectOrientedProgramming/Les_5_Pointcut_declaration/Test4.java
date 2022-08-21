package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_5_Pointcut_declaration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig4.class);

        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);

        uniLibrary.getBook();
        uniLibrary.getMagazine();

        context.close();
    }
}
