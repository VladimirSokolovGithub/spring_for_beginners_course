package ru.sokolov.spring.chapter_3_HibernateBasics.Les_7_Getting_Java_objects_from_the_database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sokolov.spring.chapter_3_HibernateBasics.Les_4_Creating_a_relationship_between_class_and_table.entity.Employee;

import java.util.List;


//Перед тем, как работать с базой из нашего Java приложения, мы должны создать Сессию для
// того, чтобы иметь связь с нашей базой данных. Сессии мы можем получить из Session factory.
// Далее мы должны создать саму сессию. Сессию мы получаем у фабрики, вызвав метод getCurrentSession().

public class Test5 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        // Теперь рассмотрим как можно получать объекты из БД не по id, а по другим любым условиям.
        // Для получения объектов из базы не по id используется HQL (Hibernate Query Language) и
        // он очень похож на SQL.

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction(); //откроем транзакцию

            //Получим всех работников и выведем их на экран.
            // Для этого создадим список работников и вызовем у сессии метод создания запроса к БД.
            // В параметрах этого метода для вывода всех работников напишем createQuery("from Employee").
            // И После создания этого запроса мы получаем его результат с помощью метода getResultList().

            List<Employee> employeeList = session.createQuery("from Employee").getResultList();

            //Employee подчёркивается красным, но это не ошибка, если запустить код, то он
            // прекрасно отработает. На что стоит обратить пристальное внимание, так это на то, что
            // мы пишем выше в запросе не имя таблицы, а имя класса.

            //После этого выведем в консоль всех работников с помощью обычного for each loop.

            for (Employee e : employeeList){
                System.out.println(e);
            }
            System.out.println();


            //Теперь получим всех работников по имени Александр.
            //При этом так же указывается название поля name нашего класса Employee, а не столбец в БД.
            List<Employee> employeeList2 = session.createQuery("from Employee " +
                    "where name = 'Aleksandr'").getResultList();

            for (Employee e : employeeList2){
                System.out.println(e);
            }
            System.out.println();


            //Теперь получим всех работников по имени Александр, кто зарабатывает больше 650
            List<Employee> employeeList3 = session.createQuery("from Employee " +
                    "where name = 'Aleksandr' AND salary > 650").getResultList();

            for (Employee e : employeeList3){
                System.out.println(e);
            }
            System.out.println();


            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close(); // закрываем factory
        }
    }
}
