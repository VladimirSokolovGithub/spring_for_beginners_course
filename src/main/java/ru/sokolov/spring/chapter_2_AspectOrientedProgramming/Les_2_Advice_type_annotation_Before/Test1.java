package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_2_Advice_type_annotation_Before;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    //Мы не будем использовать xml файл для конфигурации Spring, будем использовать Java code
    // и класс MyConfig.

    //Далее мы создадим посредника - AOP Proxy (мы не будем писать какой-либо код касательно
    // этого Proxy). И когда будет вызываться метод getBook, то мы хотим чтобы происходило
    // логирование этого процесса. Сделаем так что бы это логирование происходило до основной
    // функциональности метода getBook класса Library. Как нам это сделать?
    // Для начала мы должны добавить в наш MyConfig классе прописать аннотацию -
    // @EnableAspectJAutoProxy - эта аннотация позволяет нам за кулисами использовать Spring AOP Proxy.
    // После этого мы должны создать класс Aspect. Это обычный класс, в который помимо аннотации
    // @Component добавлена аннотация @Aspect. Таким образом Aspect - это класс, отвечающий за
    // сквозную функциональность.

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Library library = context.getBean("libraryBean", Library.class);
        library.getBook();

        context.close();
    }
}
