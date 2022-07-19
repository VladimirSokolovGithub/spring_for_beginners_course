package ru.sokolov.spring.chapter_1_IoC_and_DI.Les_18_annotation_Qualifier;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sokolov.spring.chapter_1_IoC_and_DI.Les_16_annotation_Autowired_for_the_setter.Person2;

public class Test12_AnnotationQualifier {

    //Из предыдущего урока у нас было 2 класса помеченных аннотацией @Component - это класс Cat -
    // @Component("catBean") и класс Person2 - @Component("personBean2") и внедрение зависимости
    // с помощью аннотации @Autowired по полю private Pet pet; класса Person2.
    // Теперь добавим ещё одну аннотацию @Component классу Dog без указания id в скобках,
    // у неё будет дефолтный id - dog. Теперь под наш тип Pet будут подходить два бина c id catBean и dog.
    // При запуске нашей программы ниже в таком варианте мы получим Exception - NoUniqueBeanDefinitionException,
    // expected single matching bean but found 2: catBean,dog.
    // И что же делать в этом случае, не убирать же у класса Dog или Cat аннотацию @Component.
    // Мы просто должны указать после аннотации @Autowired в классе Person2 какой именно бин должен
    // использоваться при внедрении зависимости. Это достигается с помощью аннотации @Qualifier.
    // Мы укажем в классе Person2 - @Qualifier("dog").

    //Так же аннотацию @Qualifier можно использовать для любого injection - setter или constructor, но
    // в конструкторе будет немного другой синтаксис написания аннотации @Qualifier (смотрим презентацию).

//Все манипуляции происходят в классе Person2

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext5.xml");

        //Получаем Person2 из Спринг контейнера.
        Person2 person = context.getBean("personBean2", Person2.class);
        person.callYourPet();

        context.close();
    }

}
