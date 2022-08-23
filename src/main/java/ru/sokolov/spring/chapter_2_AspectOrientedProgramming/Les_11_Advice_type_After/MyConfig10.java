package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_11_Advice_type_After;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_11_Advice_type_After") //Указываем где будут сканироваться наши компоненты
@EnableAspectJAutoProxy //эта аннотация позволяет нам за кулисами использовать Spring AOP Proxy
public class MyConfig10 {

}
