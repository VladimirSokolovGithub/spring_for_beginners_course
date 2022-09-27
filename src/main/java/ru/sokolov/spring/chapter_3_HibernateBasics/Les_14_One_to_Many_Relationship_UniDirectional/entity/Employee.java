package ru.sokolov.spring.chapter_3_HibernateBasics.Les_14_One_to_Many_Relationship_UniDirectional.entity;

import javax.persistence.*;

@Entity
@Table(name = "employees3")

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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }
}
