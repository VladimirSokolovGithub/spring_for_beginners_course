package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_2_Advice_type_annotation_Before;

import org.springframework.stereotype.Component;

@Component("libraryBean")
public class Library {

    public void getBook(){
        System.out.println("Мы берем книгу. We take the book");
    }

}
