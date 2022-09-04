package ru.sokolov.spring.chapter_3_HibernateBasics.Les_3_Connecting_Java_application_to_database;

public class Info1 {

    //config file hibernate.cfg.xml содержит информацию, как hibernate будет подключаться к базе данных.
    //
//    <hibernate-configuration>
//    <session-factory> // создаёт сессию для соединения нашего приложения с базой данных
//        <property name="connection.url">jdbc:mysql://localhost:3306/my_db?useSSL=false&amp;serverTimezone=UTC</property> // здесь прописываем где находится наша база
//        <property name="connection.driver_class">com.mysql.cj.jdbc.Driver</property> //драйвер который мы скачали и добавили jar файл к нам в проект
//        <property name="connection.username">bestuser</property> // имя пользователя
//        <property name="connection.password">bestuser</property> // пароль
//
//        <property name="current_session_context_class">thread</property> //тред к которому привязана сессия, чаще всего параметр - thread т.е. привязана к треду в котором мы создаем сессию
//        <property name="dialect">org.hibernate.dialect.MySQLDialect</property> // параметр dialect - org.hibernate.dialect.MySQLDialect - так как мы работаем с MySQL, то указываем MySQLDialect
//        <property name="show_sql">true</property> // show_sql - true, полезно для тестирования и отслеживания. В консоли будет отображаться какое SQL выражение было послано нашей базе из приложения
//
//    </session-factory>
//    </hibernate-configuration>


    //Далее в видеоуроке 039 Подключение Java приложения к БД будет показана настройка netbeans с помощью
    //maven и pom файла. Подходит так же для maven проектов.

}
