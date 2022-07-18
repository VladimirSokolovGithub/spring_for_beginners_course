package ru.sokolov.spring.chapter_1_IoC_and_DI.Les_15_annotation_Autowired_for_the_constructor;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sokolov.spring.chapter_1_IoC_and_DI.Les_6_dependency_injection_introduction.Person;

public class Test9_AutowiredConstructor {

    //Аннотация @Autowired (переводится как - автоматическое подключение) помогает нам внедрить зависимости,
    // и нам уже не придётся показывать Spring-у в xml файле какой бин необходимо внедрять т.к.
    // он это сделает автоматически.
    // Такую аннотацию @Autowired мы установим в классе Person у конструктора с параметрами.


    //Код ниже работает следующим образом:
    // Spring сканирует пакеты, ищет классы посеченные аннотацией @component, сейчас это классы
    // Cat и Person, scope их singleton, поэтому он сразу создаёт эти бины. Затем Spring видит
    // аннотацию @Autowired на конструкторе класса Person и пытается внедрить зависимости (каким образом? -
    // он ищет есть ли подходящие бины по типу, в нашем случае внедряется зависимость по типу Pet с
    // помощью конструктора класса Person. И Спринг контейнер смотрит что у него есть созданные бины
    // с типом Pet и если он их находит, то внедряет зависимость).

    //Так же начиная с версии Spring 4.3, если класс имеет один конструктор, то мы можем не указывать
    // аннотацию @Autowired над конструктором класса Person и Spring всё равно будет использовать
    // этот конструктор и внедрять зависимость на его основе. Но лучше всегда писать эту аннотацию, это
    // делает код более читабельным.

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext5.xml");

        //Получаем Person из Спринг контейнера.
        Person person = context.getBean("personBean", Person.class);
        person.callYourPet();

        context.close();
    }



}
