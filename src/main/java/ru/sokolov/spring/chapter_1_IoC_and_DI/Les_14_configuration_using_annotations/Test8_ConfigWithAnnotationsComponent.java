package ru.sokolov.spring.chapter_1_IoC_and_DI.Les_14_configuration_using_annotations;

//В этом уроке будет рассмотрена конфигурация с помощью аннотаций и небольшого xml файла

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sokolov.spring.chapter_1_IoC_and_DI.Les_4_5_inversion_of_control.Cat;

public class Test8_ConfigWithAnnotationsComponent {

//смотреть файл  - applicationContext5
    //Добавление аннотации @component в класс Cat - @Component("catBean"), в скобках в двойных кавычках
    // указывается id для бина.
    //Таким образом Spring будет искать в пакете java все аннотации - @component("id бина") и регистрировать их
    // с соответствующими id, которые указаны в скобках в Spring container.

    //Так же мы можем аннотацию @Component писать без скобок и не указывать никакого id. В этом случае
    // Spring сам будет присваивать default id бину. И делает он это по определенным правилам: Дефолтный
    // bean id получается из имени класса над которым указана аннотация @component, заменяется первая
    // заглавная буква класса на прописную. (Исключение если в названии класса подряд идут две заглавные
    // буквы, тогда bean id будет точно такой же как и название класса).

    //Если поставить аннотацию @component над всеми нашими классами Cat, Dog и Person, и scope при этом
    // будет singleton, то при сканировании нашего пакета с классами создастся три готовых к использованию бина.

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext5.xml");

//        Cat myCat = context.getBean("catBean", Cat.class);
        Cat myCat = context.getBean("cat", Cat.class);
        myCat.say();

        context.close();
    }

}
