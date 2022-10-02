package ru.sokolov.spring.chapter_3_HibernateBasics.Les_16_Many_to_Many_relationship_Part1_and_Part2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sokolov.spring.chapter_3_HibernateBasics.Les_16_Many_to_Many_relationship_Part1_and_Part2.entity.Child;
import ru.sokolov.spring.chapter_3_HibernateBasics.Les_16_Many_to_Many_relationship_Part1_and_Part2.entity.Section;

public class Test13 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try {
//            session = factory.getCurrentSession();
//
//            Section section1 = new Section("Football");
//            Child child1 = new Child("Vova", 5);
//            Child child2 = new Child("Masha", 7);
//            Child child3 = new Child("Vasya", 6);
//
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child2);
//            section1.addChildToSection(child3);
//
//            session.beginTransaction();
//
//            session.save(section1);
//
//            session.getTransaction().commit();
//            System.out.println("Done!!!");

            //***********************************************************

//            session = factory.getCurrentSession();
//
//            Section section2 = new Section("Volleyball");
//            Section section3 = new Section("Chess");
//            Section section4 = new Section("Math");
//
//            Child child4 = new Child("Igor", 10);
//                child4.addSectionToChild(section2);
//                child4.addSectionToChild(section3);
//                child4.addSectionToChild(section4);
//
//            session.beginTransaction();
//
//            session.save(child4);
//
//            session.getTransaction().commit();
//            System.out.println("Done!!!");

            //***********************************************************

            //Получим первую секцию с id 1 по футболу и выведем информацию о ней и о
            // детях которые в ней занимаются, в консоль.
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Section section = session.get(Section.class, 1);
//
//            System.out.println(section);
//            System.out.println(section.getChildren());
//
//            session.getTransaction().commit();
//            System.out.println("Done!!!");

            //***********************************************************

            //Теперь получим всю предыдущую информацию не по секции, а по ребенку.
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Child child = session.get(Child.class, 4);
//
//            System.out.println(child);
//            System.out.println(child.getSections());
//
//            session.getTransaction().commit();
//            System.out.println("Done!!!");

            //***********************************************************

            //Теперь удалим секцию
            //Если оставить cascade без изменений, то удалится не только секция, но и все дети, которые
            // посещают эту секцию, но этого допустить нельзя т.к. дети могут посещать и другие секции тоже.
            // Поэтому из каскада в классах Section и Child нужно убрать тип REMOVE. (т.е. вместо типа
            // .ALL выбрать четыре типа кроме REMOVE - @ManyToMany(cascade = {CascadeType.PERSIST,
            // CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}))

//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Section section = session.get(Section.class, 1);
//            session.delete(section);
//
//            session.getTransaction().commit();
//            System.out.println("Done!!!");

            //***********************************************************

//            session = factory.getCurrentSession();
//
//            Section section1 = new Section("Football");
//            Child child1 = new Child("Vova", 5);
//            Child child2 = new Child("Masha", 7);
//            Child child3 = new Child("Vasya", 6);
//
//            session.beginTransaction();
//
//            // Так как мы поменяли в аннотации @ManyToMany(cascade = CascadeType.ALL) тип каскада
//            // ALL на остальные четыре типа PERSIST,MERGE, REFRESH, DETACH, теперь мы не можем
//            // воспользоваться каскадным сохранением и добавить детей в секции и сохранить из
//            // в таблицу нашей БД при сохранении секции - session.save(section1), поэтому теперь
//            // нам необходимо после сохранения секции добавить детей в эту секции и только потом
//            // сохранить их отдельно, каждого ребенка. Смотрим код ниже.
//            //Дело в том, что когда мы использовали тип CascadeType.ALL в него входили все операции
//            // для cascade. Сейчас у нас для cascade остались 4 операции, в том числе и PERSIST.
//            // Оказывается save и PERSIST - это два разных метода, они выполняют одну задачу,
//            // сохранение объекта в БД, но выполняют они эту задачу по-разному. И теперь наш
//            // cascade поддерживает метод PERSIST, но не метод save.
//            // И теперь когда CascadeType не ALL, каскадного сохранения с помощью метода save
//            // не будет, но мы можем запросто написать вместо save метод persist и всё прекрасно
//            // каскадно сохранится.
//            //Теперь смотрим следующий блок кода после звездочек, вернем всё на свои места и поверим
//            // каскадное сохранение.
//
//            session.save(section1);
//
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child2);
//            section1.addChildToSection(child3);
//
//            session.save(child1);
//            session.save(child2);
//            session.save(child3);
//
//            session.getTransaction().commit();
//            System.out.println("Done!!!");

            //***********************************************************

//            session = factory.getCurrentSession();
//
//            Section section1 = new Section("Dance");
//            Child child1 = new Child("Yulia", 12);
//            Child child2 = new Child("Grisha", 8);
//            Child child3 = new Child("Pavlik", 9);
//
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child2);
//            section1.addChildToSection(child3);
//
//            session.beginTransaction();
//
//            session.persist(section1); //*** вот здесь меняем метод save на persist
//
//            session.getTransaction().commit();
//            System.out.println("Done!!!");

            //***********************************************************

            //Удалим секцию танцев.
            //И теперь когда каскадного удаления у нас нет, то дети удалиться не должны.

//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Section section = session.get(Section.class, 6);
//            session.delete(section);
//
//            session.getTransaction().commit();
//            System.out.println("Done!!!");

            //***********************************************************

            //Теперь удалим из БД ребенка, при этом все секции которые этот ребенок посещает
            // должны остаться.

            session = factory.getCurrentSession();

            session.beginTransaction();

            Child child = session.get(Child.class, 4);
            session.delete(child);

            session.getTransaction().commit();
            System.out.println("Done!!!");

        }
        finally {
            session.close();
            factory.close();
        }
    }
}
