package ru.sokolov.spring.chapter_3_HibernateBasics.Les_12_One_to_One_Relationship_Bidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sokolov.spring.chapter_3_HibernateBasics.Les_12_One_to_One_Relationship_Bidirectional.entity.Detail;
import ru.sokolov.spring.chapter_3_HibernateBasics.Les_12_One_to_One_Relationship_Bidirectional.entity.Employee;

//Теперь необходимо сделать так, чтобы выполняя какие-нибудь действия не с Employee а уже с
// Detail и что бы действия Detail распространялось и на Employee тоже. Для этого наш
// объект Detail должен знать с каким Employee он связан. Эту связь мы установим в классе
// Detail с помощью поля "private Employee employee".

public class Test9 {
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
//            Employee employee = new Employee("Misha", "Sidorov"
//                    ,"HR", 850);
//            Detail detail = new Detail("London", "15564648498"
//                    , "misha@gmail.com");
//
//            detail.setEmployee(employee); //Если добавим так, то у объекта employee не будет
//                                          // связи с таблицей details и столбец details_id в таблице
//                                          // employees2 будет null
//
//            session.beginTransaction(); //Открываем транзакцию
//
//            session.save(detail);
//
//            session.getTransaction().commit(); //Закрываем транзакцию(подтверждаем свои действия)
//            System.out.println("Done!");


//            session = factory.getCurrentSession();
//            //Создадим наши объекты
//            Employee employee = new Employee("Nikolay", "Ivanov"
//                    ,"HR", 850);
//            Detail detail = new Detail("New-York", "6458963214"
//                    , "nikolay@gmail.com");
//
//            //Здесь мы должны деталям добавить работника, но и самому работнику нужно перед этим
//            // добавить детали.
//            //И теперь после того как мы сохраним детали, то и работник сохранится с полной информацией
//            // и столбец details_id в таблице employees2 уже не будет null.
//            employee.setEmpDetail(detail);
//            detail.setEmployee(employee);
//
//            session.beginTransaction(); //Открываем транзакцию
//
//            //И теперь после того как мы сохраним детали, то и работник сохранится с полной информацией
//            // и столбец details_id в таблице employees2 уже не будет null
//            session.save(detail);
//
//            session.getTransaction().commit(); //Закрываем транзакцию(подтверждаем свои действия)
//            System.out.println("Done!");


//            //Теперь получим информацию из Базы Данных.
//            session = factory.getCurrentSession();

//            session.beginTransaction(); //Открываем транзакцию
//
//            //Будем получать Detail и с помощью Detail будем получать информацию о самом работнике и
//            // выведем её на экран.
//            Detail detail = session.get(Detail.class, 4);
//            System.out.println(detail.getEmployee());

//            session.getTransaction().commit(); //Закрываем транзакцию(подтверждаем свои действия)
//            System.out.println("Done!");


//            //Теперь удалим из Базы Данных наши детали.
//            session = factory.getCurrentSession();
//
//            session.beginTransaction(); //Открываем транзакцию
//            Detail detail = session.get(Detail.class, 4);
//            session.delete(detail);
//
//            session.getTransaction().commit(); //Закрываем транзакцию(подтверждаем свои действия)
//            System.out.println("Done!");



            //Теперь попробуем удалить только детали. Но для этого нам нужно в Detail удалить
            // cascade = CascadeType.ALL в аннотации @OneToOne(mappedBy = "empDetail", cascade = CascadeType.ALL)
            // или изменить CascadeType с ALL на PERSIST и REFRESH.
            // Получим деталь с id 2 - Oleg и удалим её. И в этом случае работник Oleg не должен
            // удалиться. Но выйдет Exception так как
            // работник Oleg в столбце "details_id" ссылается на детали с id 2 - это Foreign Key. Foreign Key всегда должен
            // ссылаться на Primary Key и он ссылается на Primary Key - столбец "id" из таблицы details - на строчку
            // с деталями Олега. Если мы удалим эту строку, то на что тогда будет ссылаться этот
            // employee Oleg? Это противоречит логике Foreign Key, поэтому так делать невозможно.
            // Поэтому перед тем как удалить строку в таблице details с id 2 мы должны убедиться в том, что
            // нет работников, которые на неё ссылаются. Сначала мы эту связь должны разорвать, после чего
            // мы сможем удалить детали и сохранить работника.
            // Поэтому мы должны с помощью кода detail.getEmployee().setEmpDetail(null); разорвать связь.

            session = factory.getCurrentSession();

            session.beginTransaction(); //Открываем транзакцию

            Detail detail = session.get(Detail.class, 2); //получили детали
            detail.getEmployee().setEmpDetail(null);//* теперь разрушим связь с работником Oleg
            session.delete(detail);

            session.getTransaction().commit(); //Закрываем транзакцию(подтверждаем свои действия)
            System.out.println("Done!");

        } finally {
            session.close();
            factory.close(); // закрываем factory
        }
    }

}
