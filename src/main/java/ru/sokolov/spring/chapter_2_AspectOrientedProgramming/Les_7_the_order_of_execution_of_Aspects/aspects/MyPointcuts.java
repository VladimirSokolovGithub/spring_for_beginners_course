package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_7_the_order_of_execution_of_Aspects.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {

    @Pointcut("execution(* get*())")
    public void allGetMethods(){
    }

}
