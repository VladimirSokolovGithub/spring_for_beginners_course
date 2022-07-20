package ru.sokolov.spring.chapter_1_IoC_and_DI.Les_20_Scope_PostConstruct_and_PreDestroy_annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sokolov.spring.chapter_1_IoC_and_DI.Les_13_Init_and_destroy_methods.Dog1;
import ru.sokolov.spring.chapter_1_IoC_and_DI.Les_4_5_inversion_of_control.Dog;

public class Test15_PostConstruct_and_PreDestroy_Annotations {

    //Некоторое время назад рассматривали как в xml файле прописывать init и destroy методы.
    // Это методы, которые вызываются в определенный период жизненного цикла бина.
    // У данных методов access modifier может быть любым.
    // У данных методов return type может быть любым, но из-за того, что возвращаемое значение
    // никак не может быть использовано, то чаще всего return type это- void.
    // Называться данные методы могут как угодно
    // и у этих методов не должно быть параметров.

    //Если у бина scope = prototype, то:
    // - init -method будет вызываться для каждого новосозданного бина.
    // - для этого бина destroy -method вызываться не будет.
    // - если необходимо выполнить работу из destroy метода, то нам необходимо самостоятельно писать
    // код для закрытия/освобождения ресурсов, которые были использованы в бине.

    //За init -method отвечает аннотация - @PostConstruct (переводится как - после создания).

    //За destroy -method отвечает аннотация - @PreDestroy (переводится как - перед уничтожением).

    //Перейдем в класс Dog1 и напишем эти аннотации перед init и destroy методами.

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
               new ClassPathXmlApplicationContext("applicationContext6.xml");

        Dog1 myDog = context.getBean("dog1", Dog1.class);
        myDog.say();

        context.close();

    }


}
