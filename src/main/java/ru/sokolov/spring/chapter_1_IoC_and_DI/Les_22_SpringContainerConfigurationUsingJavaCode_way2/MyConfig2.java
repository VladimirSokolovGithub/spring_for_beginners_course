package ru.sokolov.spring.chapter_1_IoC_and_DI.Les_22_SpringContainerConfigurationUsingJavaCode_way2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import ru.sokolov.spring.chapter_1_IoC_and_DI.Les_16_annotation_Autowired_for_the_setter.Person2;
import ru.sokolov.spring.chapter_1_IoC_and_DI.Les_4_5_inversion_of_control.Cat;
import ru.sokolov.spring.chapter_1_IoC_and_DI.Les_4_5_inversion_of_control.Pet;

//Для создания и работы с нашими бинами напишем методы

@Configuration
@PropertySource("classpath:myApp.properties")
public class MyConfig2 {

    //метод будет создавать и возвращать объект Cat
    //Что бы указать что этот метод описывает бин, мы должны перед методом указать аннотацию @Bean.
    //Так же нужно отметить, что Bean id - это само название метода - catBean.

    //Так же как и при создании Spring Container (ApplicationContext) с помощью xml или annotations
    // и небольшого xml файла, при Scope -singleton, у нас будет создаваться один и тот же бин,
    // несмотря на то, что в методе catBean прописан код return new Cat();. Это достигается с
    // помощью аннотации @Bean, которая говорит Spring-у, что мы будем создавать наш бин вручную.
    // Название метода catBean, говорит что id нашего бина будет - catBean.
    // Таким образом при запросе бина с помощью context.getBean("catBean", Pet.class); аннотация
    // @Bean перехватывает наш запрос, она видит что Scope этого бина - singleton, и в
    // Spring Container этот бин уже есть, значит нет необходимости создавать ещё один новый объект
    // в нашем случае - Cat, т.е. до строчки кода return new Cat(); дело уже не доходит.

    @Bean
    @Scope("singleton") //здесь указывается Scope нашего бина и by default он - singleton
    public Pet catBean(){
        return new Cat();
    }

    //Теперь посмотрим как можно реализовать Dependency injection используя этот способ конфигурации.


    @Bean
    //здесь указывается Scope нашего бина и by default он - singleton, поэтому можно не писать
    public Person2 person2Bean(){
        return new Person2(catBean()); //в параметр вставляется наш бин Cat созданный ранее
    }


}
