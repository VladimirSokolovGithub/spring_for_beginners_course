package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_12_Advice_type_Around_Acquaintance;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary {

    public String returnBook(){
        System.out.println("Мы возвращаем книгу в UniLibrary");
        return "Война и Мир";
    }

}
