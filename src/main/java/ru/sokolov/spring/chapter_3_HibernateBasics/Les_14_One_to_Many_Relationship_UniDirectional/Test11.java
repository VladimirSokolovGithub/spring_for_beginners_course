package ru.sokolov.spring.chapter_3_HibernateBasics.Les_14_One_to_Many_Relationship_UniDirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sokolov.spring.chapter_3_HibernateBasics.Les_14_One_to_Many_Relationship_UniDirectional.entity.Department;
import ru.sokolov.spring.chapter_3_HibernateBasics.Les_14_One_to_Many_Relationship_UniDirectional.entity.Employee;

public class Test11 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;

        try {
//            session = factory.getCurrentSession();
//
//            Department dep = new Department("HR", 500, 1500);
//            Employee emp1 = new Employee("Oleg", "Ivanov", 800);
//            Employee emp2 = new Employee("Andrey", "Sidorov", 1000);
//
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//
//            session.beginTransaction();
//            session.save(dep);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");



            //Получим из таблицы наш департамент и всех его работников.
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Department department = session.get(Department.class, 2);
//            System.out.println(department);
//            System.out.println(department.getEmps());
//
//            session.getTransaction().commit();
//            System.out.println("Done!");



            //Получим из Базы работника
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 1);
//            System.out.println(employee);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");



//            //Удаление департамента
//            //Если удалять работника, то удалится только работник так как у нас Uni-directional связь
//            // И работник ничего не знает о департаменте.
//            //Но если удалить департамент, то удалятся и все работники так как у нас CascadeType.ALL.
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Department department = session.get(Department.class, 2);
//
//            session.delete(department);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");



//            //Удаление работника
//            //Если удалять работника, то удалится только работник так как у нас Uni-directional связь
//            // и работник ничего не знает о департаменте.
//
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 3);
//
//            session.delete(employee);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");


            //Удаление департамента и всех его работников для очистки таблицы
            session = factory.getCurrentSession();

            session.beginTransaction();
            Department department = session.get(Department.class, 3);

            session.delete(department);

            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            session.close();
            factory.close(); // закрываем factory
        }
    }

}
