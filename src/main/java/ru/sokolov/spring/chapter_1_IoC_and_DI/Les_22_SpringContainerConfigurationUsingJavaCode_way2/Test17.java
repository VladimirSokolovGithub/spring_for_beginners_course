package ru.sokolov.spring.chapter_1_IoC_and_DI.Les_22_SpringContainerConfigurationUsingJavaCode_way2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sokolov.spring.chapter_1_IoC_and_DI.Les_16_annotation_Autowired_for_the_setter.Person2;
import ru.sokolov.spring.chapter_1_IoC_and_DI.Les_4_5_inversion_of_control.Pet;

public class Test17 {

    //Перейдём к рассмотрению второго способа конфигурацию Spring container-а с помощью Java code.
    // Для удобства создадим новый класс MyConfig2.
    // Данный способ не использует сканирование пакета и поиск бинов и других аннотаций.
    // А если не будет происходить сканирование то отпадает необходимость писать аннотацию
    // @Component. Закомментируем компонент в классах Cat, Dog1 и Person2.

    //В данном способе мы все бины будем прописывать внутри класса MyConfig2.
    // И описывать будем не только бины но и Dependency injection.
    // И соответственно если мы в ручную будем прописывать Dependency injection, то нам
    // не нужна будет аннотация @Autowired и аннотация @Qualifier("catBean"),
    // закомментируем их в классе Person2.


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig2.class);

//        Pet cat = context.getBean("catBean", Pet.class);
//        cat.say();

        Person2 person = context.getBean("person2Bean", Person2.class);
        person.callYourPet();

    }

}
