package ru.sokolov.spring.chapter_3_HibernateBasics.Les_13_One_to_Many_Relationship_Bidirectional.entity;

import javax.persistence.*;

@Entity
@Table(name = "employees2")

public class Employee {

    @Id //аннотация @Id означает, что наше поле id это primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // аннотация @GeneratedValue позволяет задать варианты(стратегии) генерации значений для primary key столбца - id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String firstName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "salary")
    private int salary;

    public Employee() {
    }

    public Employee(String firstName, String surname, int salary) {
        this.firstName = firstName;
        this.surname = surname;
        this.salary = salary;
    }

    //05:16
}
