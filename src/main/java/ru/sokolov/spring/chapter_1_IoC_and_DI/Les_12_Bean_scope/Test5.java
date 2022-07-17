package ru.sokolov.spring.chapter_1_IoC_and_DI.Les_12_Bean_scope;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sokolov.spring.chapter_1_IoC_and_DI.Les_4_5_Inversion_of_control.Dog;

public class Test5 {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");

        // Singleton бины подходят преджде всего когда мы работаем со stateless объектами.
        // State - переводится как состояние.

        //Добавим нашим собакам имена
        Dog myDog = context.getBean("myPet", Dog.class);
        myDog.setName("Belka");

        Dog yourDog = context.getBean("myPet", Dog.class);
        yourDog.setName("Strelka");

        //Но так как объект один и тот же (bean scope - singleton) у нас выведется одно
        // и то же имя - Strelka.
        System.out.println(myDog.getName());
        System.out.println(yourDog.getName());

        //Поэтому bean scope - singleton используется для stateless бинов(объектов), т.е. для объектов,
        // состояние которых нам менять не приходится. И поэтому singleton используется тогда, когда мы
        // хотим что бы создавался всего один bean. И этот единственный бин предоставляется нам независимо
        // от того сколько раз мы его запрашиваем с помощью методы context.getBean("myPet", Dog.class);.

        //Поэтому bean scope - singleton не очень подходит для нашего бина Dog или Cat. До этого на
        // предыдущих уроках мы никогда scope наших бинов не указывали и поэтому всегда использовался
        // default scope, а дефолтным скопом является - singleton.


        //Следующий scope - это Prototype.
        //Бины с этим скопом будут создаваться каждый раз новые, когда мы захотим получить их из Spring
        // контейнера.
        //Такой Bean создается только после обращения к Spring Container-у с помощью метода context.getBean,
        // т.е он не создаётся как в случае с singleton при создании ClassPathXmlApplicationContext.


        context.close();
    }
}
