package ru.sokolov.spring.chapter_3_HibernateBasics.Les_5_Saving_Java_objects_in_the_database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sokolov.spring.chapter_3_HibernateBasics.Les_4_Creating_a_relationship_between_class_and_table.entity.Employee;


//Перед тем, как работать с базой из нашего Java приложения, мы должны создать Сессию для
// того, чтобы иметь связь с нашей базой данных. Сессии мы можем получить из Session factory.
// Далее мы должны создать саму сессию. Сессию мы получаем у фабрики, вызвав метод getCurrentSession().

public class Test1 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
//                .configure("ru.sokolov.spring.hibernate.cfg.xml")
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            //Теперь будем сохранять в базу данных объект класса Employee
            Employee employee = new Employee("Vladimir", "Sokolov", "IT", 500);

            session.beginTransaction(); //Для этого откроем транзакцию
            session.save(employee); //Сохраняем(инсёртим) объект employee в БД (INSERT)

            //Закрываем транзакцию(подтверждаем свои действия)
            session.getTransaction().commit();
        } finally {
            factory.close(); // закрываем factory
        }
    }

    //После запуска приложения в консоли появится строчка:
    //Hibernate: insert into employees (department, name, salary, surname, id) values (?, ?, ?, ?, ?)
    //Это означает, что в такие то столбцы нашей таблицы добавлены наши наши значения. Но по
    // умолчанию они отображаются в виде вопросов. Если мы хотим что бы эти значения отображались, то
    // необходимо самостоятельно добавить в проект jar файл log4j.jar. Но это уже для дальнейшей
    // самостоятельной работы, данный процесс не сложен и есть в интернете.

    //Далее необходимо перейти в MySQL Workbench, выполнить INSERT запрос и увидеть, что
    // наш объект employee и все его поля были успешно добавлены в таблицу нашей БД.

}
