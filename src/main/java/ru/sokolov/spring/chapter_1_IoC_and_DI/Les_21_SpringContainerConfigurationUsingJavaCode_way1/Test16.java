package ru.sokolov.spring.chapter_1_IoC_and_DI.Les_21_SpringContainerConfigurationUsingJavaCode_way1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sokolov.spring.chapter_1_IoC_and_DI.Les_16_annotation_Autowired_for_the_setter.Person2;
import ru.sokolov.spring.chapter_1_IoC_and_DI.Les_6_dependency_injection_introduction.Person;

public class Test16 {
    //В данном уроке рассмотрим, как можно вообще не использовать xml файл для конфигурации
    // Spring container-а. Будем осуществлять конфигурацию Spring container-а с помощью
    // Java code. Есть 2 способа.

    //1 способ.
    //Необходимо создать класс public class MyConfig и перед классом мы должны прописать 2 аннотации:
    // @Configuration
    // @ComponentScan("ru")

    //Аннотация @Configuration - означает, что данный клас является конфигурацией
    //Аннотацией @ComponentScan("ru") - мы указываем какой пакет нужно сканировать на
    // наличие бинов и других аннотаций.
    //В данном уроке сам класс MyConfig будет пустым, заполнять мы его будем на следующем уроке,
    // когда будем рассматривать второй способ конфигурации Spring container-а с помощью Java code.

    //В данном уроке будем работать с классом Person и классом Cat

    public static void main(String[] args) {
        // Для создания ApplicationContext (Spring Container) теперь мы будем использовать класс
        // AnnotationConfigApplicationContext, который в параметры конструктора принимает наш
        // config класс - MyConfig
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Person2 person = context.getBean("personBean2", Person2.class);
        person.callYourPet();

        context.close();

    }
}
