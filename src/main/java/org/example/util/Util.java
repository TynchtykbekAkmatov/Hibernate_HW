package org.example.util;

import org.example.model.User;
import org.hibernate.HibernateError;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Util {
    // реализуйте настройку соеденения с БД

//    private static final String url = "jdbc:postgresql://localhost:5432/jdbc";
//    private static final String userName = "postgres";
//    private static final String password = "postgres213";
//
//    public static Connection getConnection(){
//        Connection conn =null;
//        try {
//            conn = DriverManager.getConnection(url,userName,password);
//
//        }catch (SQLException e){
//            e.getMessage();
//        }
//        return conn;
//    }
//
//}
//----------------------------------------------------xml file menen:---------------------------
//    public static SessionFactory getSession() {
//        try {
//            return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//        } catch (HibernateError e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
//    }
//-------------------------------------Java аннотаций жардамы менен конфигурация кылу-----------
    public static SessionFactory getSession(){
    Configuration configuration = new Configuration();
    Properties prop = new Properties();
    prop.setProperty("connection.driver_class", "com.postgresql.Driver");
    prop.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/Hibernate");
    prop.setProperty("hibernate.connection.username", "postgres");
    prop.setProperty("hibernate.connection.password", "postgres213");
    prop.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
    prop.setProperty("hibernate.show_sql", "true");
    prop.setProperty("hibernate.hbm2ddl.auto", "update");
    prop.setProperty("hibernate.current_session_context_class", "thread");

    configuration.setProperties(prop);
    configuration.addAnnotatedClass(User.class);
    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
    return configuration.buildSessionFactory(serviceRegistry);
}
}