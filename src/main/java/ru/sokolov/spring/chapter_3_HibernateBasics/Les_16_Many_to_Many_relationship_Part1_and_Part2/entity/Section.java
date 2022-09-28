package ru.sokolov.spring.chapter_3_HibernateBasics.Les_16_Many_to_Many_relationship_Part1_and_Part2.entity;

import javax.persistence.*;

@Entity
@Table(name = "section")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public Section() {
    }

    public Section(String name) {
       this.name = name;
    }

    //00:12:14
}
