package ru.sokolov.spring.chapter_1_IoC_and_DI.Les_13_Init_and_destroy_methods;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test7_InitAndDestroyMethod {

    //Жизненный цикл бина - смотреть скриншот - (1_Bean life cycle)

    //init-method - это наша возможность сделать так, что бы вызвался написанный нами метод.
    //init - означает initialization (инициализация). В init методе мы пишем код, который хотим
    // чтобы выполнился при создании бина. Только после выполнения этого метода идёт следующий шаг -
    // - что бин готов для использования. Мы используем этот бин, получаем его с помощью метода
    // context.getBean из Spring Container-а, что то с ним делаем, выполняем какую-то работу,
    // после чего наступает конец работы Spring Container-а (context.close();). После этого
    // вызывается destroy-method. Он вызывается после завершения работы Spring Container-а но
    // до завершения работы нашего приложения. Затем идёт остановка приложения. В destroy-method-е
    // обычно пишется логика, которая должна выполняться после окончания работы с бином, но до его
    // уничтожения.
    //Эти два метода init и destroy, которые мы можем написать сами, вызываются автоматически Spring-ом.

    //Чаще всего init-method используется для открытия или настройки каких-либо ресурсов, например баз
    // данных, стримов ит.д.

    //destroy-method чаще всего используется для их закрытия.

    //В init и destroy методе можно задавать любую логику.

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext4.xml");

        Dog1 myDog = context.getBean("myPet", Dog1.class);
        myDog.say();
        //методы init и destroy класса Dog1 вызовутся Spring-ом автоматически.

        Dog1 yourDog = context.getBean("myPet", Dog1.class);
        yourDog.say();


        context.close();

    }


}
