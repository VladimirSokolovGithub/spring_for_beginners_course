package ru.sokolov.spring.chapter_1_IoC_and_DI.Les_6_dependency_injection_introduction;

//У каждого домашнего животного должен быть любящий его хозяин.
//Создадим клас Person и пропишем в его конструктор Pet

import ru.sokolov.spring.chapter_1_IoC_and_DI.Les_4_5_Inversion_of_control.Pet;

public class Person {
    private Pet pet;
    //Les_9_10_Embedding_strings_and_other_values
    private String surname;
    private int age;

    //Les_7_dependency_injection_using_the_constructor
    //В этом примере Person, мы добавляем ему животное, указываем эту зависимость через конструктор.
    //Теперь напишем эту зависимость в нашем config файле.
//    public Person(Pet pet) {
//        System.out.println("Person bean is created");
//        this.pet = pet;
//    }

    public Person() {
        System.out.println("Person bean is created");
    }

    //pet -> setPet () - конвертация pet в setPet
    public void setPet(Pet pet) {
        System.out.println("Class Person: set pet");
        this.pet = pet;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        System.out.println("Class Person: set surname");
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Class Person: set age");
        this.age = age;
    }

    public void callYourPet(){
        System.out.println("Hello, my lovely Pet!");
        pet.say();
    }
}
