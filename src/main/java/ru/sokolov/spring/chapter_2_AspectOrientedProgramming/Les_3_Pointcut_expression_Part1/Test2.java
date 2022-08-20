package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_3_Pointcut_expression_Part1;

//Для написания Pointcut мы используем шаблон (см.слайд 1_Pointcut_1).
//Жирным шрифтом в шаблоне обозначены обязательные элементы.
//Обычным шрифтом обозначены опциональные элементы со знаком вопроса, это означает что эти
// элементы могут быть, а могут и не быть в нашем Pointcut.
//Под шаблон могут подходить один или несколько методов, это зависит от того насколько
// детально мы опишем шаблон.
//Вообще шаблон описывает метод. Если этот метод будет подходить под шаблон, тогда при
// вызове этого метода будет вызываться и наш Advice.


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig2.class);

        UniLibrary uniLibrary = context.getBean("uniLibrary2", UniLibrary.class);
//        uniLibrary.getBook();
        uniLibrary.returnBook();
//        uniLibrary.getMagazine();

//        SchoolLibrary schoolLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
//        schoolLibrary.getBook();

        context.close();
    }
}
