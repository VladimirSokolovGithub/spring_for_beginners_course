package ru.sokolov.spring.chapter_3_HibernateBasics.Les_11_One_to_One_relationship_Unidirectional_Part_1_and_2;

public class FirstInfo {

}

//Uni-directional - это однонаправленная связь между таблицами (однонаправленные отношения между таблицами).
// Когда одна сторона о них просто не знает. Например, есть класс Parent и класс Child. У класса Parent есть
// ссылка на класс Child, а у класса Child ссылки на класс Parent нет.

//Bi-directional - это двунаправленная связь между таблицами (двунаправленные отношения между таблицами).
// Когда обе стороны знают друг о друге. И у класса Parent есть ссылка на класс Child, и у класса
// Child есть ссылка на класс Parent.

//Далее создаем две таблицы (details and employees2) в MySQL Workbench
//Файл со скриптом находится в папке с уроком, а так же добавлен в текущий package.