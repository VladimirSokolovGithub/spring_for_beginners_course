package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_7_the_order_of_execution_of_Aspects;

import org.springframework.stereotype.Component;


@Component
public class UniLibrary {

    public void getBook() {
        System.out.println("Мы берем книгу из UniLibrary. We take the book from UniLibrary");
    }

    public void returnBook(){
        System.out.println("Мы возвращаем книгу в UniLibrary");
    }

    public void getMagazine(){
        System.out.println("Мы берем журнал из UniLibrary");
    }

    public void returnMagazine(){
        System.out.println("Мы возвращаем журнал в UniLibrary");
    }

    public void addBook() {
        System.out.println("Мы добавляем книгу в UniLibrary");
    }

    public void addMagazine() {
        System.out.println("Мы добавляем журнал в UniLibrary");
    }
}
