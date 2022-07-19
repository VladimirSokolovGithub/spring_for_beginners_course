package ru.sokolov.spring.chapter_1_IoC_and_DI.Les_6_dependency_injection_introduction;

//У каждого домашнего животного должен быть любящий его хозяин.
//Создадим клас Person и пропишем в его конструктор Pet

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sokolov.spring.chapter_1_IoC_and_DI.Les_4_5_inversion_of_control.Pet;

//@Component("personBean") //закомментировано из за урока Les_18_annotation_Qualifier
public class Person {
    private Pet pet;
    //Les_9_10_Embedding_strings_and_other_values
    private String surname;
    private int age;

    //Les_7_dependency_injection_using_the_constructor
    //В этом примере Person, мы добавляем ему животное, указываем эту зависимость через конструктор.
    //Теперь напишем эту зависимость в нашем config файле.

    //Разкомментировали конструктор на уроке 15  - Les_15_annotation_Autowired_for_the_constructor

//    @Autowired //закомментировано из за урока Les_18_annotation_Qualifier
    public Person(Pet pet) {
        System.out.println("Person bean is created");
        this.pet = pet;
    }

    //Закомментировали конструктор на уроке 15  - Les_15_annotation_Autowired_for_the_constructor
//    public Person() {
//        System.out.println("Person bean is created");
//    }

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
