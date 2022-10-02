package ru.sokolov.spring.chapter_3_HibernateBasics.Les_16_Many_to_Many_relationship_Part1_and_Part2;

public class FirstInfo {

}

//Рассмотрим отношение many_to_many. Мы будем работать с кружками и детьми.
//В кружке может быть несколько детей и так же у ребенка может быть много кружков.
//И нам необходимо отслеживать всё это множество связей между детьми и кружками и наоборот.
//Для отслеживания таких связей между таблицами у нас есть помощник в лице join table -
// - смотри слайд №2.
//Join Table - это таблица, которая отображает связь между строками двух других таблиц.
//Столбцы Join Table - это Foreign Key, которые ссылаются на Primary Key связываемых таблиц.