package ru.sokolov.spring.chapter_2_AspectOrientedProgramming.Les_8_Join_Point.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {

    @Pointcut("execution(* add*(..))")
    public void allAddMethods(){
    }

}
