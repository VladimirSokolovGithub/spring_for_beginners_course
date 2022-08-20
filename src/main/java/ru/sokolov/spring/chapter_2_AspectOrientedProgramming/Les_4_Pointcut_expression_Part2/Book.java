package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_4_Pointcut_expression_Part2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {

    @Value("Таинственный остров") //назначили значение для нашего поля String name
    private String name;

    public String getName(){
        return name;
    }
}
