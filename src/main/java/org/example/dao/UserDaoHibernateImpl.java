package org.example.dao;

import org.example.model.User;
import org.example.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao{

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        try{
            Session session = Util.getSession().openSession();
            session.beginTransaction();
            session.createSQLQuery(
                     "create table if not exists users_hw(" +
                        "id serial primary key," +
                        "name varchar," +
                        "lastName varchar," +
                        "age int);").executeUpdate();
            session.getTransaction().commit();
            session.close();
                System.out.println("Tablica koshuldu");
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dropUsersTable() {
        try{
            Session session = Util.getSession().openSession();
            session.beginTransaction();
            session.createSQLQuery("drop table if exists users_hw").executeUpdate();
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try{
            Session session = Util.getSession().openSession();
            session.beginTransaction();

            User user = new User(name, lastName, age);
            session.save(user);

            session.getTransaction().commit();
            session.close();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeUserById(long id) {
        try{
            Session session = Util.getSession().openSession();
            session.beginTransaction();

//            User user = session.get(User.class, id);
//            session.delete(user);
            session.createSQLQuery("delete from users_hw where id = "+ id).executeUpdate();

            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<User> getAllUsers() {
        try{
            Session session = Util.getSession().openSession();
            session.beginTransaction();
            List<User> users = session.createQuery("from User").getResultList();

            session.getTransaction().commit();
            session.close();
            return users;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void cleanUsersTable() {
        try {
            Session session = Util.getSession().openSession();
            session.beginTransaction();
            session.createSQLQuery("delete from users_hw").executeUpdate();
            session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public User getById(Long id) {
        try {
            Session session = Util.getSession().openSession();
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.getTransaction().commit();
            session.close();
            return user;
        }catch (HibernateException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override // bir userdi alyp aga ozgortuu kirgizebiz.
    public User updateUser(Long id, String name, String lastName, int age) {
        try{
            Session session = Util.getSession().openSession();
            session.beginTransaction();
            User user = session.get(User.class, id);
            user.setId(id);
            user.setName(name);
            user.setLastName(lastName);
            user.setAge((byte) age);
            session.getTransaction().commit();
            session.close();
            return user;
        } catch (HibernateException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
