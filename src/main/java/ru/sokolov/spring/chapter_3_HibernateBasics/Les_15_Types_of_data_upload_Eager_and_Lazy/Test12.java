package ru.sokolov.spring.chapter_3_HibernateBasics.Les_15_Types_of_data_upload_Eager_and_Lazy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sokolov.spring.chapter_3_HibernateBasics.Les_15_Types_of_data_upload_Eager_and_Lazy.entity.Department;
import ru.sokolov.spring.chapter_3_HibernateBasics.Les_15_Types_of_data_upload_Eager_and_Lazy.entity.Employee;

public class Test12 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;

        try {
            //1************************************************************

//            session = factory.getCurrentSession();
//
//            Department dep = new Department("Sales", 800, 1500);
//            Employee emp1 = new Employee("Vladimir", "Sokolov", 800);
//            Employee emp2 = new Employee("Elena", "Smirnova", 1500);
//            Employee emp3 = new Employee("Anton", "Sidorov", 1200);
//
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            dep.addEmployeeToDepartment(emp3);
//
//            session.beginTransaction();
//            session.save(dep);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

            //2***********************************************************

            //Получим из таблицы информацию о департаменте с id 4 и так как мы используем
            // FetchType.EAGER то мы так же получим и информацию обо всех его работниках.
            // FetchType.EAGER делает сразу SELECT всего и департамента и работников и потом
            // выводит нам сразу эту информацию по нашему запросу.

            //Далее поменяем FetchType на LAZY в классе Department и посмотрим что получилось.
            // FetchType.LAZY - hibernate делает сначала выборку департамента и выводит его нам
            // и только затем после нашего запроса делает выборку работников и выводит их нам.
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            System.out.println("Get department");
//            Department department = session.get(Department.class, 4);
//
//            System.out.println("Show department");
//            System.out.println(department);
//
//            System.out.println("Show employees of the department");
//            System.out.println(department.getEmps());
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

            //3 ************************************************************

//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            System.out.println("Get department");
//            Department department = session.get(Department.class, 4);
//
//            System.out.println("Show department");
//            System.out.println(department);
//
//            session.getTransaction().commit(); //Завершение сессии
//
//            //Теперь рассмотрим работу типа выборки после того, как произошел commit при этом
//            // изменим FetchType на EAGER. У нас всё отработает нормально и выведется информация
//            // о наших работниках. Потому что при типе выборки FetchType.EAGER была подгружена
//            // информация и о департаменте и о работниках до коммита т.е до завершения работы
//            // нашей сессии.
//
//            //Теперь если мы поменяем FetchType на LAZY и ещё раз запустим наш код. То мы получим
//            // LazyInitializationException так как перед этим мы сделали commit() и закрыли сессию,
//            // а после этого просим подгрузить информацию о работниках.
//
//            //Этого Exception-а можно избежать если например до commit-а загрузить информацию
//            //о каком то работнике. - смотрим следующий код №4
//            System.out.println("Show employees of the department");
//            System.out.println(department.getEmps());
//
//            System.out.println("Done!");

            //4 ************************************************************

            session = factory.getCurrentSession();

            session.beginTransaction();

            System.out.println("Get department");
            Department department = session.get(Department.class, 4);

            System.out.println("Show department");
            System.out.println(department);

            System.out.println("подгрузим наших работников");
            department.getEmps().get(0); //получим из List-а работника с индексом 0, но тем самым
            //мы заранее подгрузим всех работников.

            session.getTransaction().commit(); //Завершение сессии

            System.out.println("Show employees of the department");
            System.out.println(department.getEmps()); // и теперь уже после commit-а мы этих работников
                                                      //ранее подгруженных можем получить

            System.out.println("Done!");


        } finally {
            session.close();
            factory.close(); // закрываем factory
        }
    }

}
