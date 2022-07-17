package ru.sokolov.spring.chapter_1_IoC_and_DI.Les_6_dependency_injection_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] args) {

        //Пока создадим всё стандартным способом без функциональности Spring
//        Pet pet = new Cat();

        //Теперь изменим Test3 используя уже имеющиеся знания Spring
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

//        Pet pet = context.getBean("myPet", Pet.class);
//        Person person = new Person(pet);
        Person person = context.getBean("myPerson", Person.class);
        person.callYourPet();


        //Добавление составляющих Employee объектов в сам объект Employee и называется Dependency Injection.

        //Les_7_dependency_injection_using_the_constructor
        //Теперь после того как мы добавили зависимость с помощью конструктора в конфиг файл, нам
        // достаточно получить бин Person - объект Person и вызвать метод callYourPet(). В Person
        // бине уже будет внедрена зависимость, нам уже не нужно вручную писать этот код -
        // - Person person = new Person(pet); и внедрять зависимость самостоятельно, это уже делает за нас
        // spring framework с помощью dependency injection. Более того мы уже с объектом Pet в коде
        // уже не сталкиваемся, потому что spring контейнер создаст все бины сам из конфиг файла и внедрит
        // необходимые зависимости. Теперь мы объект Person можем получить из ApplicationContext.
        //02-12

        //Les_9_10_Embedding(Внедрение)_strings_and_other_values
        System.out.println(person.getSurname());
        System.out.println(person.getAge());



        context.close();
    }
}
