package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_8_Join_Point;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {

    @Value("Три толстяка") //назначили значение для нашего поля String name
    private String name;

    @Value("Юрий Олеша")
    private String author;

    @Value("1866")
    private int yearOfPublication;


    public String getName(){
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }
}
