package ru.sokolov.spring.chapter_1_IoC_and_DI.Les_19_annotation_Value;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sokolov.spring.chapter_1_IoC_and_DI.Les_16_annotation_Autowired_for_the_setter.Person2;

public class Test13_AnnotationValue {
    //Все манипуляции происходят в классе Person2

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext5.xml");

        //Получаем Person2 из Спринг контейнера.
        Person2 person = context.getBean("personBean2", Person2.class);
        person.callYourPet();

        System.out.println(person.getSurname());
        System.out.println(person.getAge());

        context.close();
    }
}
