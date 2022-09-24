package ru.sokolov.spring.chapter_3_HibernateBasics.Les_11_One_to_One_relationship_Unidirectional_Part_1_and_2.entity;

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

    @Column(name = "department")
    private String department;

    @Column(name = "salary")
    private int salary;

    //Аннотацией @OneToOne  мы говорим что между классом Employee и между классом Detail
    // будут One-To-One отношения.
    //Далее с помощью аннотации @JoinColumn мы должны показать на основе каких полей строятся эти отношения.
    // Этой аннотацией @JoinColumn(name = "details_id") мы говорим hibernate-у, что для связи
    // с классом Detail в таблице employees2, которая связана с нашим классом Employee есть столбец
    // details_id. И уже за кулисами Hibernate сам понимает эту логику связи. Он видит, что details_id
    // это Foreign Key для таблицы employees2, и ссылается этот столбец на столбец id из таблицы details.
    // Таким образом Hibernate понимает что существует One-To-One связь между Employee и Detail классами
    // и какие поля этих классов данную связь осуществляют.

    //Аннотация @OneToOne
    // cascade = CascadeType.ALL говорит нам при выполнении каких
    // операций на одном entity (например удаление) эти операции будут распространиться и на другие
    // entity, которые связаны с первым entity.
    // Есть следующие типы операций:
    // PERSIST - сохранение объекта;
    // MERGE - объединение;
    // REMOVE - удаление;
    // REFRESH - обновление состояния объекта;
    // DETACH - удаляет объект из постоянного контекста.
    // Эти типы cascade очень тесто связаны с названиями состояний entity т.е. в каких состояниях entity
    // бывает во время жизненного цикла
    // Если в аннотации @OneToOne мы не укажем cascade, то по умолчанию операции cascade не будут работать.
    // И так (cascade = CascadeType.ALL) означает, что если мы теперь удалим работника, связанные с ним
    // детали так же будут автоматически удалены. Если сохраним работника, то в базу сохраняться и
    // связанные с ним детали тоже.
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id")
    private Detail empDetail;

    public Employee(){
    }

    //Создадим конструктор с полями кроме поля id. id будет генерироваться базой данных самостоятельно.
    public Employee(String name, String surname, String department, int salary) {
        this.firstName = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + firstName + '\'' +
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

    public Detail getEmpDetail() {
        return empDetail;
    }

    public void setEmpDetail(Detail empDetail) {
        this.empDetail = empDetail;
    }
}
