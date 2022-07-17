package ru.sokolov.spring.chapter_1_IoC_and_DI.Les_12_Bean_scope;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sokolov.spring.chapter_1_IoC_and_DI.Les_4_5_Inversion_of_control.Dog;

public class Test6 {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext3.xml");

        //Следующий scope - это Prototype.
        //Бины с этим скопом будут создаваться каждый раз новые(разные объекты), когда мы захотим
        // получить их из Spring контейнера.
        //Такой Bean создается только после обращения к Spring Container-у с помощью метода context.getBean,
        // т.е он не создаётся как в случае с singleton при создании ClassPathXmlApplicationContext.
        //Для каждого такого обращения, создаётся новый бин в Spring Container-е.

        // Когда мы используем scope="prototype" заранее в Spring Container-е бин не создаётся, а
        // Создаётся от только тогда, когда мы его запрашиваем у объекта ClassPathXmlApplicationContext
        // с помощью метода context.getBean("myPet", Dog.class);

        //scope Prototype подходит для stateful объектов.
        //stateful объекты - это те объекты, которые хранят какое-либо состояние, например имя собаки.

        //Первое обращение к Spring Container за бином
        Dog myDog = context.getBean("myPet", Dog.class);
        myDog.setName("Belka");

        //Второе обращение к Spring Container за бином
        Dog yourDog = context.getBean("myPet", Dog.class);
        yourDog.setName("Strelka");

        System.out.println(myDog.getName());
        System.out.println(yourDog.getName());

        System.out.println("Переменные ссылаются на один и тот же объект? "
                + "Do the variables refer to the same object? - "
                + (myDog == yourDog));
        System.out.println(myDog);
        System.out.println(yourDog);


        context.close();
    }
}
