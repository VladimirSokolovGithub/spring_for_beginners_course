package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_12_Advice_type_Around_Acquaintance;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test11 {
    public static void main(String[] args) {
        System.out.println("Method Main starts");

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig11.class);

        UniLibrary library = context.getBean("uniLibrary", UniLibrary.class);

        String bookName = library.returnBook();
        System.out.println("В библиотеку вернули книгу " + bookName);

        context.close();
        System.out.println("Method Main ends");
    }
}
