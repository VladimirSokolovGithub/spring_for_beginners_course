package ru.sokolov.spring.chapter_3_HibernateBasics.Les_4_Creating_a_relationship_between_class_and_table.entity;

import javax.persistence.*;

@Entity
@Table(name = "employees") //В аннотации @Table() прописываем с какой таблицей будет связан класс Employee.
                           // В нашем случае с таблицей - employees.
//В аннотации @Table() можно не указывать имя таблицы если название таблицы совпадает с названием класса.
// Но в любом случае лучше все таки это имя прописать.

//Далее будет необходимо связать поля нашего класса со столбцами в таблице. Делается это с помощью
// аннотации @Column(name = "id").
//Отдельно мы должны пометить, что наш id в таблице это primary key. Это делается с помощью
// аннотации @Id.

//Разработчики Hibernate рекомендуют использовать аннотации JPA(см.слайд 5), что мы и сделали.
// Это сделано для того, что если завтра мы захотим поменять Hibernate на другую реализацию
// JPA, то используя аннотации JPA нам не придется менять весь код. Так как другая реализация
// JPA тоже будет использовать эти аннотации.

//Hibernate поддерживает несколько стратегий или вариантов генерации значений для primary key столбца.
// Эти варианты генерации значений описывает аннотация @GeneratedValue. (Смотрим Les_4 - класс Employee).

public class Employee {

    @Id //аннотация @Id означает, что наше поле id это primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // аннотация @GeneratedValue позволяет задать варианты(стратегии) генерации значений для primary key столбца
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "department")
    private String department;

    @Column(name = "salary")
    private int salary;

    public Employee(){
    }

    //Создадим конструктор с полями кроме поля id. id будет генерироваться базой данных самостоятельно.
    public Employee(String name, String surname, String department, int salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
