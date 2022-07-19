package ru.sokolov.spring.chapter_1_IoC_and_DI.Les_4_5_inversion_of_control;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//default bean id = dog
@Component
//@Scope("singleton")
@Scope("prototype")
public class Dog implements Pet{

    private String name;

    public Dog(){
        System.out.println("Dog bean is created");
    }

    @Override
    public void say(){
        System.out.println("Bow-Waw");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
