package com.example.GestEvent.Services;

import com.example.GestEvent.HibernateUtil;
import com.example.GestEvent.Modul.Users;
import org.hibernate.Session;

import  org.hibernate.query.Query;
import java.util.List;

public class UserService {
    Session session;

    public void addUser(Users user) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        System.out.println("add user");
    }
    public Users getUserById(int id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Users users = session.find(Users.class, id);
        session.getTransaction().commit();
        return users;
    }

    public List<Users> getAllUsers() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Users> listUsers = session.createQuery("from Users ").list();
       session.getTransaction().commit();
        return listUsers;
    }

    public void deleteUser(int id){
        Users users;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        users = session.find(Users.class, id);
        if (users != null){
            session.delete(users);
            session.flush();
            System.out.println("User delete");

        }
        else{
            System.out.println("User does not exist");
        }
        session.getTransaction().commit();
    }

    public Users updateUser(Users user){
        Users users;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        users = session.find(Users.class, user.getId());
        if (users != null){
            users.setFirstName(user.getFirstName());
            users.setLastName(user.getLastName());
            users.setEmail(user.getEmail());
            users.setPassword(user.getPassword());
            users.setRole(user.getRole());
            System.out.println("User update");

        }
        else{
            System.out.println("User does not exist");
        }
        session.getTransaction().commit();


        return users;
    }

    public Users getUserByEmail(String email){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query =  session.createQuery("from Users where email=: email");
        query.setParameter("email", email);
        try {
            Users user = (Users) query.getSingleResult();
            return user;
        }
        catch (Exception e){
            return null;
        }
    }
}
