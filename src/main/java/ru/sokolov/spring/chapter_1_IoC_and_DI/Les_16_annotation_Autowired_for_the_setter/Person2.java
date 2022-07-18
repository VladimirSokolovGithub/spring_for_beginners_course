package ru.sokolov.spring.chapter_1_IoC_and_DI.Les_16_annotation_Autowired_for_the_setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sokolov.spring.chapter_1_IoC_and_DI.Les_4_5_inversion_of_control.Pet;

@Component("personBean2")
public class Person2 {

    private Pet pet;

    private String surname;
    private int age;

    @Autowired
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
