package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_3_Pointcut_expression_Part1;

import org.springframework.stereotype.Component;

@Component
public class SchoolLibrary extends AbstractLibrary {

    @Override
    public void getBook() {
        System.out.println("Мы берем книгу из SchoolLibrary. We take the book from SchoolLibrary");
    }
}
