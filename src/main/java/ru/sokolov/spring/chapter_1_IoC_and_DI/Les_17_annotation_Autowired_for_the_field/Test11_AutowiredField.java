package ru.sokolov.spring.chapter_1_IoC_and_DI.Les_17_annotation_Autowired_for_the_field;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sokolov.spring.chapter_1_IoC_and_DI.Les_16_annotation_Autowired_for_the_setter.Person2;

public class Test11_AutowiredField {
    public static void main(String[] args) {

        //Все манипуляции происходят в классе Person2

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext5.xml");

        //Получаем Person2 из Спринг контейнера.
        Person2 person = context.getBean("personBean2", Person2.class);
        person.callYourPet();

        context.close();

        //В уроках с 15 по 17 мы разобрали три вида @Autowired инъекций. Если возник вопрос какой из них
        // выбрать при написании определенного проекта, то ответ - выбираем абсолютно любой,
        // тот который нам больше нравиться. Так как основная функция которую они преследуют одна и та же.
        // Просто выбрав определенный тип инъекций нужно придерживаться его во всем проекте.

    }
}
