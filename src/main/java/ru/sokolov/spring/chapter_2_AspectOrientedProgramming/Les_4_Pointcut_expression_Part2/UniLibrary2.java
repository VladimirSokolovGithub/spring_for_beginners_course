package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_4_Pointcut_expression_Part2;

import org.springframework.stereotype.Component;


@Component
public class UniLibrary2 {

//    public void getBook(String bookName) {
//        System.out.println("Мы берем книгу из UniLibrary. We take the book from UniLibrary: " + bookName);
//    }

    public void getBook(Book book) {
        System.out.println("Мы берем книгу из UniLibrary. We take the book from UniLibrary: " + book.getName());
    }

    public void getMagazine(int a){
        System.out.println("\"Мы берем журнал из UniLibrary");
    }
}
