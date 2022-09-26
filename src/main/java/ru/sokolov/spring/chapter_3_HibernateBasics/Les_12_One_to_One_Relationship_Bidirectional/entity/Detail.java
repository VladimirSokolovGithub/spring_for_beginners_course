package ru.sokolov.spring.chapter_3_HibernateBasics.Les_12_One_to_One_Relationship_Bidirectional.entity;

import javax.persistence.*;

@Entity
@Table(name = "details")
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "city")
    private String city;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    //С помощью аннотации @OneToOne и ёё параметрами (mappedBy = "empDetail") мы говорим,
    // что связь между Detail и Employee есть в классе Employee в поле "empDetail".
    // При этом нам не нужно снова прописывать аннотации @OneToOne(cascade = CascadeType.ALL) и
    // @JoinColumn(name = "details_id") как над полем "private Detail empDetail" в классе
    // Employee и устанавливать эту связь снова, потому что достаточно уже того что мы её
    // указали один раз в классе Employee над полем "private Detail empDetail".
    // При этом мы так же можем задать каскад и для поля "private Employee employee" вторым
    // параметром аннотации @OneToOne.

//    @OneToOne(mappedBy = "empDetail", cascade = CascadeType.ALL)
//    private Employee employee;

    @OneToOne(mappedBy = "empDetail", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private Employee employee;

    public Detail(){
    }

    //Создадим конструктор с полями кроме поля id. id будет генерироваться базой данных самостоятельно.
    public Detail(String city, String phoneNumber, String email) {
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
