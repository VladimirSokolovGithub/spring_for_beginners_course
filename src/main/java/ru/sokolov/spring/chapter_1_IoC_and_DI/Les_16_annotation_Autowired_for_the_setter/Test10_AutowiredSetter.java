package ru.sokolov.spring.chapter_1_IoC_and_DI.Les_16_annotation_Autowired_for_the_setter;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sokolov.spring.chapter_1_IoC_and_DI.Les_6_dependency_injection_introduction.Person;

public class Test10_AutowiredSetter {

    //В классе Person2 нет конструкторов, поэтому при создании бина сработает конструктор по умолчанию.
    //Пропишем аннотацию @Autowired над сеттером - setPet в классе Person2.

    //Так как у нас стоит аннотация @Component("personBean") ещё и над классом Person, а scope
    // у нас singleton, то будет создан ещё и бин класса Person и выведено его диагностическое
    // сообщение из конструктора.

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext5.xml");

        //Получаем Person2 из Спринг контейнера.
        Person2 person = context.getBean("personBean2", Person2.class);
        person.callYourPet();

        context.close();

    }
}
