package ru.sokolov.spring.chapter_3_HibernateBasics.Les_13_One_to_Many_Relationship_Bidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sokolov.spring.chapter_3_HibernateBasics.Les_11_One_to_One_relationship_Unidirectional_Part_1_and_2.entity.Detail;
import ru.sokolov.spring.chapter_3_HibernateBasics.Les_11_One_to_One_relationship_Unidirectional_Part_1_and_2.entity.Employee;


public class Test10 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;

        try {
//            session = factory.getCurrentSession();
//            //Создадим наши объекты
//            Employee employee = new Employee("Vladimir", "Sokolov"
//                    ,"IT", 500);
//            Detail detail = new Detail("Elista", "1234567899"
//                    , "vladimir@gmail.com");
//
//            employee.setEmpDetail(detail); //добавляем дополнительную информацию нашему работнику
//
//            session.beginTransaction(); //Открываем транзакцию
//
//            //Теперь для добавления объектов в таблицы, просто достаточно сохранить работника. И детали
//            // этого работника автоматически благодаря каскаду @OneToOne(cascade = CascadeType.ALL) тоже
//            // сохранятся в соответствующей таблице.
//
//            session.save(employee);
//
//            session.getTransaction().commit(); //Закрываем транзакцию(подтверждаем свои действия)
//            System.out.println("Done!");


//            session = factory.getCurrentSession();
//            Employee employee = new Employee("Oleg", "Smirnov"
//                    ,"Sales", 700);
//            Detail detail = new Detail("Moscow", "51614651651"
//                    , "oleg@gmail.com");
//
//            employee.setEmpDetail(detail)
//            session.beginTransaction();
//
//            session.save(employee);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");


//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            //Получим из базы данных работника с id 1
//            Employee emp = session.get(Employee.class, 1);
//            //Теперь выведем на экран детали этого работника.
//            // При этом я не писал код, который получает детали для этого работника. Мы просто запросили
//            // из БД нашего работника. Но благодаря каскаду @OneToOne(cascade = CascadeType.ALL), мы получаем
//            // из базы не только объект Employee, но и объект Detail, который связан с объектом enmp.
//            System.out.println(emp.getEmpDetail());
//
//            session.getTransaction().commit();
//            System.out.println("Done!");


            session = factory.getCurrentSession();

            session.beginTransaction();
            //Получим из базы данных работника с id 1
            Employee emp = session.get(Employee.class, 1);
            //И удалим работника с id 1 Vladimir Sokolov из базы. При этом удалится не только объект emp,
            // но и связанные с ним детали.
            session.delete(emp);

            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            session.close();
            factory.close(); // закрываем factory
        }
    }

}
