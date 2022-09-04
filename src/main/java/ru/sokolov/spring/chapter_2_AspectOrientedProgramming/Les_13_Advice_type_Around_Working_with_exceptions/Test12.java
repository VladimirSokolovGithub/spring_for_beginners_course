package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_13_Advice_type_Around_Working_with_exceptions;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test12 {
    public static void main(String[] args) {
        System.out.println("Method Main starts");

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig12.class);

        UniLibrary library = context.getBean("uniLibrary", UniLibrary.class);

        String bookName = library.returnBook();
        System.out.println("В библиотеку вернули книгу " + bookName);

        context.close();
        System.out.println("Method Main ends");
    }
}
