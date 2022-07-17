package ru.sokolov.spring.chapter_1_IoC_and_DI.Les_12_Bean_scope;

//С помощью scope (область видимости) мы определяем, то как spring контейнер создаёт наши бины.
//Рассмотрим пример bean scope - singleton(одиночка) - является scope-ом по умолчанию.
//Для этого создадим новый config файл - applicationContext2.xml

//Наш spring контейнер может читать информацию не только из одного config файла, но и из нескольких. Для
// этого необходимо разделить их запятой: new ClassPathXmlApplicationContext("applicationContext2.xml", "applicationContext.xml");

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sokolov.spring.chapter_1_IoC_and_DI.Les_4_5_Inversion_of_control.Dog;

public class Test4 {
    public static void main(String[] args) {
        //При запуске в такой конфигурации в консоль будет выведено сообщение о том, что "Dog bean is created".
        // Это означает что бин был создан. Это означает, что бин создаётся даже если мы его не запрашиваем( в Test4
        // мы нигде не писали context.getBean). Как это произошло? - Spring контейнер прочитал наш config файл
        // увидел, что в нём есть  такой бин, scope не указан, значит scope - singleton и Spring контейнер создал
        // bean Dog, даже если мы его не запрашиваем, а года мы запрашиваем context.getBean, то мы берем уже
        // готовый объект.
        // Таким образом жизненный цикл этого бина начинается с чтения Spring контейнером config файла.
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");

        Dog myDog = context.getBean("myPet", Dog.class);
        Dog yourDog = context.getBean("myPet", Dog.class);

        //Проверим теперь что Bean singleton является общим для всех, кто запросит его у Spring контейнера т.е
        // проверим ссылается ли myDog и yourDog на один и тот же объект.

        System.out.println("Переменные ссылаются на один и тот же объект? " + "Do the variables refer to the same object? "
                + (myDog == yourDog));
        System.out.println(myDog);
        System.out.println(yourDog);

        // Singleton бины подходят преджде всего когда мы работаем со stateless объектами.
        // State - переводится как состояние.
        // переходим в класс Test5

        context.close();

    }
}
