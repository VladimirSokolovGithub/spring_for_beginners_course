package ru.sokolov.spring.chapter_1_IoC_and_DI.Les_4_5_Inversion_of_control;

public class Cat implements Pet {

    public Cat(){
        System.out.println("Cat bean is created");
    }

    @Override
    public void say(){
        System.out.println("Meow-Meow");
    }


}
