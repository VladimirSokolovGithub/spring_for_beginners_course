package ru.sokolov.spring.chapter_1_IoC_and_DI.Les_13_Init_and_destroy_methods;

import ru.sokolov.spring.chapter_1_IoC_and_DI.Les_4_5_inversion_of_control.Pet;

public class Dog1 implements Pet {

    public Dog1(){
        System.out.println("Dog bean is created");
    }

    @Override
    public void say(){
        System.out.println("Bow-Waw");
    }

    //Les_13_Init_and_destroy_methods
    //Создадим init-method.
    protected void init() {
        System.out.println("Class Dog: init-method");
    }

    //Создадим destroy-method/
    private void destroy() {
        System.out.println("Class Dog: destroy-method");
    }
}
