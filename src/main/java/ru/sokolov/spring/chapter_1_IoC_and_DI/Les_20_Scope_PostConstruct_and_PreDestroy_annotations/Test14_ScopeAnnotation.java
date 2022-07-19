package ru.sokolov.spring.chapter_1_IoC_and_DI.Les_20_Scope_PostConstruct_and_PreDestroy_annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sokolov.spring.chapter_1_IoC_and_DI.Les_4_5_inversion_of_control.Dog;

public class Test14_ScopeAnnotation {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext6.xml");

        Dog myDog = context.getBean("dog", Dog.class);
        Dog yourDog = context.getBean("dog", Dog.class);

        System.out.println("Переменные ссылаются на один и тот же объект? " + (myDog==yourDog));
        System.out.println("Variables refer to the same object? " + (myDog==yourDog));
        System.out.println(myDog);
        System.out.println(yourDog);

        context.close();

        //00:04:45
    }

}
