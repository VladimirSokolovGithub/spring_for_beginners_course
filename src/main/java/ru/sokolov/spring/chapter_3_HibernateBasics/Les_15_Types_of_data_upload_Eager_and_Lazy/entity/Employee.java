package ru.sokolov.spring.chapter_3_HibernateBasics.Les_15_Types_of_data_upload_Eager_and_Lazy.entity;

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

    //Когда мы работаем с аннотацией @JoinColumn() мы всегда прописываем в ней столбец Foreign Key.
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;

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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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
