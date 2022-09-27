package ru.sokolov.spring.chapter_3_HibernateBasics.Les_13_One_to_Many_Relationship_Bidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sokolov.spring.chapter_3_HibernateBasics.Les_13_One_to_Many_Relationship_Bidirectional.entity.Department;
import ru.sokolov.spring.chapter_3_HibernateBasics.Les_13_One_to_Many_Relationship_Bidirectional.entity.Employee;


public class Test10 {
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
//            Department dep = new Department("IT", 300, 1200);
//            Employee emp1 = new Employee("Vladimir", "Sokolov", 800);
//            Employee emp2 = new Employee("Elena", "Smirnova", 1000);
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


            //Получим из Базы работника и узнаем его департамент
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 1);
//            System.out.println(employee);
//            System.out.println(employee.getDepartment());
//
//            session.getTransaction().commit();
//            System.out.println("Done!");


            //Теперь рассмотрим пример с удалением работника (Это плохой пример
            // так как cascade = CascadeType.ALL)
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 1);
//
//            //Так как у нас и в Employee и в Department cascade = CascadeType.ALL, то
//            // при такой записи удалятся все работники и департамент, а не работник с id = 1.
//            // Так как удаление работника с id = 1 потянуло за собой удаление департамента, а
//            // удаление департамента потянуло за собой удаление и работника с id = 2.
//            // Такая же ситуация возникнет и при удалении департамента.
//            // Для правильной работы нужно в обоих классах убрать CascadeType.ALL, а именно
//            // уберем из этого ALL Remove и оставим все остальное.
//            session.delete(employee);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");


            //Правильный пример удаления работника, при этом в классах Employee и Department
            // меняем CascadeType.ALL на

            session = factory.getCurrentSession();

            session.beginTransaction();
            Employee employee = session.get(Employee.class, 1);

            session.delete(employee);

            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            session.close();
            factory.close(); // закрываем factory
        }
    }

}
