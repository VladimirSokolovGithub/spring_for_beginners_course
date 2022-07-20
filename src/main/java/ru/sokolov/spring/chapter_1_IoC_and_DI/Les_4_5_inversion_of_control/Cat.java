package ru.sokolov.spring.chapter_1_IoC_and_DI.Les_4_5_inversion_of_control;

import org.springframework.stereotype.Component;

//@Component("catBean") //Прописывать id это хороший тон //Закомментированно из за урока - Les_22_SpringContainerConfigurationUsingJavaCode_way2;
//@Component
public class Cat implements Pet {

    public Cat(){
        System.out.println("Cat bean is created");
    }

    @Override
    public void say(){
        System.out.println("Meow-Meow");
    }


}
