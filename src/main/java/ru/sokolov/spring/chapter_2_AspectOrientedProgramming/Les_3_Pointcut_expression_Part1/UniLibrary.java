package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_3_Pointcut_expression_Part1;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary{

    @Override
    public void getBook(){
        System.out.println("Мы берем книгу из UniLibrary. We take the book from UniLibrary");
    }

//    public void returnBook() {
//        System.out.println("Мы возвращаем книгу в UniLibrary. We are returning the book in UniLibrary");
//    }

    //Добавим return type String методу returnBook, закоментируя предыдущий метод для проверки
    //нашего Advice, что бы не зависеть от return type.

    //    public String returnBook() {
    protected String returnBook() {
        System.out.println("Мы возвращаем книгу в UniLibrary. We are returning the book in UniLibrary");
        return "OK!";
    }

    public void getMagazine(){
        System.out.println("Мы берем журнал из UniLibrary. We take the magazine from UniLibrary");
    }
}
