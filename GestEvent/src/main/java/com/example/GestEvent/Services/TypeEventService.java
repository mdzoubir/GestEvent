package com.example.GestEvent.Services;

import com.example.GestEvent.HibernateUtil;
import com.example.GestEvent.Modul.Formateur;
import com.example.GestEvent.Modul.EventType;
import org.hibernate.Session;

import java.util.List;

public class TypeEventService {
    Session session;

    public void addTypeEvent(EventType typeEvent) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(typeEvent);
        session.getTransaction().commit();
        System.out.println("add typeEvent");
    }

    public EventType getTypeEventById(int id) {
        EventType typeEvent;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        typeEvent = session.find(EventType.class, id);
        session.getTransaction().commit();

        if (typeEvent != null){
            return typeEvent;
        }
        else {
            System.out.println("typeEvent does not exist");
            return null;
        }
    }

    public List<EventType> getAllTypeEvent() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<EventType> typeEventList = session.createQuery("from EventType ").list();
        session.getTransaction().commit();
        return typeEventList;
    }


    //delete typeEvent
    public void deleteTypeEvent(int id){
        EventType typeEvent;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        typeEvent = session.find(EventType.class, id);
        if (typeEvent != null){
            session.delete(typeEvent);
            session.flush();
            System.out.println("typeEvent delete");

        }
        else{
            System.out.println("typeEvent does not exist");
        }
        session.getTransaction().commit();
    }


    //update typeEvent
    public EventType updateTypeEvent(EventType t){
        EventType typeEvent;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        typeEvent = session.find(EventType.class, t.getId());
        if (typeEvent != null){
            typeEvent.setTypeEvent(t.getTypeEvent());
            System.out.println("typeEvent update");
        }
        else{
            System.out.println("typeEvent does not exist");
        }
        session.getTransaction().commit();

        return typeEvent;
    }
}
