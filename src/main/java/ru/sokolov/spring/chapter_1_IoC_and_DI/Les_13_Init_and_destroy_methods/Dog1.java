package ru.sokolov.spring.chapter_1_IoC_and_DI.Les_13_Init_and_destroy_methods;

import org.springframework.stereotype.Component;
import ru.sokolov.spring.chapter_1_IoC_and_DI.Les_4_5_inversion_of_control.Pet;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component // Закомментированно из за урока - Les_22_SpringContainerConfigurationUsingJavaCode_way2;
public class Dog1 implements Pet {

    public Dog1(){
        System.out.println("Dog1 bean is created");
    }

    @Override
    public void say(){
        System.out.println("Bow-Waw");
    }

    //Les_13_Init_and_destroy_methods
    //Создадим init-method.
    //Закомментирован для урока 21 - Les_21_SpringContainerConfigurationUsingJavaCode_way1;
//    @PostConstruct
//    protected void init() {
//        System.out.println("Class Dog: init-method");
//    }

    //Создадим destroy-method/
    //Закомментирован для урока 21 - Les_21_SpringContainerConfigurationUsingJavaCode_way1;
//    @PreDestroy
//    private void destroy() {
//        System.out.println("Class Dog: destroy-method");
//    }

    //В данном примере с @PostConstruct и @PreDestroy аннотациями, java их не находит
    // и они горят красным. Дело в том, что в версии java 9 аннотации из одного модуля стали
    // устаревшими, а для 11-й версии java они были удалены. Поэтому с помощью maven нам
    // нужно закачать их самостоятельно и добавить в проект.


}
