package ru.sokolov.spring.chapter_3_HibernateBasics.Les_6_Generating_values_for_the_Primary_Key_column;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sokolov.spring.chapter_3_HibernateBasics.Les_4_Creating_a_relationship_between_class_and_table.entity.Employee;


//Перед тем, как работать с базой из нашего Java приложения, мы должны создать Сессию для
// того, чтобы иметь связь с нашей базой данных. Сессии мы можем получить из Session factory.
// Далее мы должны создать саму сессию. Сессию мы получаем у фабрики, вызвав метод getCurrentSession().

public class Test2 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            //Теперь будем сохранять в базу данных объект класса Employee

//            Employee employee = new Employee("Mikhail", "Ivanov", "HR", 750);

//            Employee employee = new Employee("Aleksandr", "Smirnov", "Sales", 700);

            Employee employee = new Employee("Aleksandr", "Ivanov", "IT", 600);

            session.beginTransaction(); //Для этого откроем транзакцию
            session.save(employee); //Сохраняем(инсёртим) объект employee в БД (INSERT)

            //Закрываем транзакцию(подтверждаем свои действия)
            session.getTransaction().commit();

            System.out.println("Done!");
            System.out.println(employee);

        } finally {
            factory.close(); // закрываем factory
        }
    }

    //Hibernate поддерживает несколько стратегий или вариантов генерации значений для primary key столбца.
    // Эти варианты генерации значений описывает аннотация @GeneratedValue. (Смотрим Les_4 - класс Employee).
    // Для MySQL баз аннотация со стратегией @GeneratedValue(strategy = GenerationType.IDENTITY) является
    // наиболее правильной и самой распространенной. Не нежно полагаться на автоматический выбор стратегии,
    // желательно прописывать её самостоятельно.

    //После того как работник добавился в таблицу и id сгенерировался и значение этого id передаётся
    // в поле id нашего объекта employee. Это говорит о том что вид объекта в Java и вид строки в БД
    // будут идентичны.
}
