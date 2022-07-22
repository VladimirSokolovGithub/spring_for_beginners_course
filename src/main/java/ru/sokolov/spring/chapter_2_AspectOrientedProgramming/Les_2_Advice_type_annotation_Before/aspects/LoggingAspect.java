package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_2_Advice_type_annotation_Before.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//Изначально наша аннотация @Aspect будет подсвечена красным, так как Spring не видит данную
// аннотацию. Это происходит потому что несмотря на то, что мы используем Spring AOP, нам всё равно
// в проекте нужен jar file (библиотека) - AspectJ. Это необходимо так как Spring AOP использует
// некоторые AspectJ классы и аннотации. Поэтому нам нужно добавить в проект jar файл.
// Для этого зайдём на сайт https://mvnrepository.com/ и введём в поиске - aspectj weaver.
// Далее выбираем AspectJ Weaver, выбираем последнюю версию. Я выбрал последнюю версию 1.9.9.1.
// Далее у нас два пути можно скачать jar файл или добавить зависимость в файл pom.xml если мы
// используем maven проект. (Добавить через зависимость в файл pom.xml не получилось, хотя всё
// отработало, поэтому я добавил первым способом и затем импортировал в класс LoggingAspect.)

//Advice - переводится как "совет". Это ещё один термин из AOP. Это метод, который находится в
// Aspect классе и который определяет, что должно произойти при вызове метода из нашего основного
// класса с Бизнес логикой. В нашем случае это класс Library и метод getBook.

//Так же нужно отметить что в классе Aspect обычно содержится не один Advice метод, а несколько.

@Component
@Aspect
public class LoggingAspect {
    @Before("execution(public void getBook())") //Читается как, перед выполнением метода
                        // public void getBook(), нужно выполнить метод beforeAddBookAdvice
    //Такое написание - всё что указано в скобках называется pointCut - это какое-то выражение,
    // которое говорит нам когда должен выполниться сквозной код.
    public void beforeAddBookAdvice(){
        System.out.println("beforeAddBookAdvice: попытка получить книгу. Trying to get a book");
    }
}

//00-22-14