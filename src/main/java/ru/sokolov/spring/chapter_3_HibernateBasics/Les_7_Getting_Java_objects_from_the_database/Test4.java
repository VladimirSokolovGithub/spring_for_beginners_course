package ru.sokolov.spring.chapter_3_HibernateBasics.Les_7_Getting_Java_objects_from_the_database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sokolov.spring.chapter_3_HibernateBasics.Les_4_Creating_a_relationship_between_class_and_table.entity.Employee;


//Перед тем, как работать с базой из нашего Java приложения, мы должны создать Сессию для
// того, чтобы иметь связь с нашей базой данных. Сессии мы можем получить из Session factory.
// Далее мы должны создать саму сессию. Сессию мы получаем у фабрики, вызвав метод getCurrentSession().

public class Test4 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            Employee employee = new Employee("Oleg", "Sidorov", "HR", 700);

            //Так же можно добавить работника в БД и получить его из БД используя одну транзакцию т.е.
            // совместить эти две операции в одной транзакции.

            session.beginTransaction(); //Для этого откроем транзакцию
            session.save(employee); //Сохраняем(инсёртим) объект employee в БД (INSERT)
            int myId = employee.getId();

            Employee employeeSelectFromDb = session.get(Employee.class, myId); // (get - Это команда SELECT в SQL)
            session.getTransaction().commit();
            System.out.println(employeeSelectFromDb);

            System.out.println("Done!");

        } finally {
            factory.close(); // закрываем factory
        }
    }
}
