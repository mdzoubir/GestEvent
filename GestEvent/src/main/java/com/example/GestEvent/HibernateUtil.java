package com.example.GestEvent;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static SessionFactory buildSessionFactory(){
        try{
            //create the ssesionFactory from hibenate.sfg.xml
            return new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
        }catch (Throwable ex){
            System.out.println("Initial Session creaton failed ." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory(){
        return  sessionFactory;
     }
}
