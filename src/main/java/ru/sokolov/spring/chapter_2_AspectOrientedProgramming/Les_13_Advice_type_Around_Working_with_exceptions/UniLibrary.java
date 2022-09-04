package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_13_Advice_type_Around_Working_with_exceptions;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary {

    public String returnBook(){
        int a = 10/0; //сделаем так что бы наш метод выбрасывал исключение
        System.out.println("Мы возвращаем книгу в UniLibrary");
        return "Война и Мир";
    }

}
