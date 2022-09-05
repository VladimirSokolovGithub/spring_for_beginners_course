package ru.sokolov.spring.chapter_3_HibernateBasics.Les_7_Getting_Java_objects_from_the_database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sokolov.spring.chapter_3_HibernateBasics.Les_4_Creating_a_relationship_between_class_and_table.entity.Employee;


//Перед тем, как работать с базой из нашего Java приложения, мы должны создать Сессию для
// того, чтобы иметь связь с нашей базой данных. Сессии мы можем получить из Session factory.
// Далее мы должны создать саму сессию. Сессию мы получаем у фабрики, вызвав метод getCurrentSession().

public class Test3 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            //Теперь будем сохранять в базу данных объект класса Employee

            Employee employee = new Employee("Elena", "Petrova", "Sales", 800);

            session.beginTransaction(); //Для этого откроем транзакцию
            session.save(employee); //Сохраняем(инсёртим) объект employee в БД (INSERT)
            session.getTransaction().commit(); //Закрываем транзакцию(подтверждаем свои действия)

            //После того как объект добавляется в базу данных и мы коммитим это добавление. Я хочу
            // получить id этого объекта employee.

            int myId = employee.getId();

            //Далее я хочу получить этот добавленный объект из БД.
            // Во-первых, мы должны получить новую сессию так как в предыдущей мы закрыли нашу транзакцию.
            // Открыть транзакцию.
            // Далее создать нашего работника и с помощью метода get мы получаем работника с id = myId,
            // которого только что добавили.
            // После чего необходимо закрыть транзакцию коммитом.
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employeeSelectFromDb = session.get(Employee.class, myId); // (get - Это команда SELECT в SQL)
            session.getTransaction().commit();
            System.out.println(employeeSelectFromDb);

            //Так же можно добавить работника в БД и получить его из БД используя одну транзакцию т.е.
            // совместить эти две операции в одной транзакции.




            System.out.println("Done!");

        } finally {
            factory.close(); // закрываем factory
        }
    }

    //

}
