package ru.sokolov.spring.chapter_1_IoC_and_DI.Les_4_5_Inversion_of_control;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        //Объект класса ClassPathXmlApplicationContext - это Spring контейнер. Поэтому для получения бина
        // из Spring контейнера нам нужно создать ApplicationContext с помощью класса ClassPathXmlApplicationContext

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //Теперь получим объект Dog из нашего Spring контейнера.
        Pet pet = context.getBean("myPet", Pet.class); //универсальный код с использованием интерфейса.

        pet.say(); //вызываем метод say() у полученного бина Dog из нашего Spring контейнера.

        context.close(); // и обязательно нужно закрывать наш ApplicationContext.

        //Такой код универсален, для того, чтобы создать объект Cat, нам необходимо лишь изменить config файл
        // applicationContext.xml и поменять там класс Dog на класс Cat, и всё

    }
}

