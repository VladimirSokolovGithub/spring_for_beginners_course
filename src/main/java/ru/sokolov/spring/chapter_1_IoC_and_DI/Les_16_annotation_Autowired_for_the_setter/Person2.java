package ru.sokolov.spring.chapter_1_IoC_and_DI.Les_16_annotation_Autowired_for_the_setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.sokolov.spring.chapter_1_IoC_and_DI.Les_4_5_inversion_of_control.Pet;

//@Component("personBean2") // Закомментированно из за урока - Les_22_SpringContainerConfigurationUsingJavaCode_way2;
public class Person2 {

    //Для внедрения зависимости у поля так же используется аннотация @Autowired и поля могут быть даже
    // private. Получается что мы даже можем не использовать Setter-ы для внедрения зависимостей.
    // Эту аннотацию проверяем в уроке Les_17_annotation_Autowired_for_the_field в классе Test11_AutowiredField.

    //Нужно отметить одну Важную вещь. Здесь за кулисами спринг внедрит зависимость просто используя поле
    // нашего бина. И это достигается с помощью очень мощной java технологии, которая называется Reflection
    // (Рефлексия).

//    @Autowired
//    @Qualifier("dog")
    private Pet pet;

//    @Value("Sokolov")
    @Value("${person.surname}") //закомментировано из за урока Les_20_Scope_PostConstruct_and_PreDestroy_annotations
    private String surname;
//    @Value("42")
    @Value("${person.age}") //закомментировано из за урока Les_20_Scope_PostConstruct_and_PreDestroy_annotations
    private int age;

//    public Person2() {
//        System.out.println("Person bean is created");
//    }

    //Конструктор добавлен в уроке Les_18_annotation_Qualifier
    // Закомментированно из за урока - Les_22_SpringContainerConfigurationUsingJavaCode_way2;
//    @Autowired
//    public Person2(@Qualifier("catBean") Pet pet) {
//        System.out.println("Person bean is created");
//        this.pet = pet;
//    }

    //добавлен для урока -Les_22_SpringContainerConfigurationUsingJavaCode_way2;
        public Person2(Pet pet) {
        System.out.println("Person bean is created");
        this.pet = pet;
    }

//    @Autowired //для урока Les_16_annotation_Autowired_for_the_setter раскомментировать
//    @Autowired
//    @Qualifier("dog")
    public void setPet(Pet pet) {
        System.out.println("Class Person: set pet");
        this.pet = pet;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        System.out.println("Class Person: set surname");
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Class Person: set age");
        this.age = age;
    }

    public void callYourPet(){
        System.out.println("Hello, my lovely Pet!");
        pet.say();
    }
}
