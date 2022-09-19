package ru.sokolov.spring.chapter_3_HibernateBasics.Les_9_Removing_Java_objects_from_the_database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sokolov.spring.chapter_3_HibernateBasics.Les_4_Creating_a_relationship_between_class_and_table.entity.Employee;

public class Test7 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            //1 пример.
            //Получим работника с id № 1 и удалим его.

//            Employee emp = session.get(Employee.class, 1); //получаем работника из базы данных
//            session.delete(emp);

            //2 пример
            //Удалим несколько строк из нашей базы данных.
            // Удалим работников у которых имя Александр.
            //В двойных кавычках пишем hql запрос, который за кулисами будет преобразован в SQL запрос.
            //Создаем запрос с помощью метода createQuery() и с помощью метода executeUpdate() выполнить этот запрос

            session.createQuery("delete Employee where name = 'Aleksandr' ").executeUpdate();

            session.getTransaction().commit(); //с помощью .commit() регистрируем изменения в таблице БД

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
