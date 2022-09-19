package ru.sokolov.spring.chapter_3_HibernateBasics.Les_8_Changing_Java_objects_in_the_database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sokolov.spring.chapter_3_HibernateBasics.Les_4_Creating_a_relationship_between_class_and_table.entity.Employee;

public class Test6 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            //Получим работника с id № 1 и изменим ему зарплату.
//            Employee emp = session.get(Employee.class, 1); //получаем работника из базы данных
//            emp.setSalary(1500); //с помощью метода setSalary(1500) меняем зарплату

            //Изменим зарплату всем работникам в БД с именем Александр.
            //Для этого нужно уже будет написать небольшой запрос
            //Создаем запрос с помощью метода createQuery() и с помощью метода executeUpdate() выполнить этот запрос,
            // запустить его.
            session.createQuery("update Employee set salary = 1000 " +
                    "where name = 'Aleksandr'").executeUpdate();


            session.getTransaction().commit(); //с помощью .commit() регистрируем изменения в таблице БД

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
