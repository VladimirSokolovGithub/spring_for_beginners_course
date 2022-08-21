package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_5_Pointcut_declaration;

import org.springframework.stereotype.Component;


@Component
public class UniLibrary {

    public void getBook() {
        System.out.println("Мы берем книгу из UniLibrary. We take the book from UniLibrary");
    }

    public void getMagazine(){
        System.out.println("Мы берем журнал из UniLibrary");
    }
}
