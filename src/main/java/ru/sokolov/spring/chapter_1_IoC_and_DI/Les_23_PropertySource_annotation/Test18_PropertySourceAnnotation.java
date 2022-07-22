package ru.sokolov.spring.chapter_1_IoC_and_DI.Les_23_PropertySource_annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sokolov.spring.chapter_1_IoC_and_DI.Les_16_annotation_Autowired_for_the_setter.Person2;
import ru.sokolov.spring.chapter_1_IoC_and_DI.Les_22_SpringContainerConfigurationUsingJavaCode_way2.MyConfig2;

public class Test18_PropertySourceAnnotation {

    //На этом уроке рассмотрим как мы с помощью аннотации @Value будем давать значения нашим переменным,
    // конечно же используя Java code для конфигурации Spring Container.
    // Раскомментируем аннотации @Value в классе Person2.
    // Так как ранее мы наши значения прописывали в файле myApp.properties и в xml файле, то теперь
    // xml файл мы не используем, а используем класс MyConfig2.class в качестве конфигурации.
    // Для того чтобы прописать наш properties файл - myApp.properties в классе MyConfig2.class мы
    // используем аннотацию @PropertySource.


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig2.class);

        Person2 person = context.getBean("person2Bean", Person2.class);
        System.out.println(person.getSurname());
        System.out.println(person.getAge());

        context.close();

    }
}
