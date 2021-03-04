package com.example.GestEvent.Services;

import com.example.GestEvent.HibernateUtil;
import com.example.GestEvent.Modul.Events;
import org.hibernate.Session;

import java.util.List;

public class EventService {
    Session session;

    public void addEvent(Events event) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(event);
        session.getTransaction().commit();
        System.out.println("add Event");
    }

    public Events getEventById(int id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Events Event = session.find(Events.class, id);
        session.getTransaction().commit();
        return Event;
    }

    public List<Events> getAllEvent() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Events> eventList = session.createQuery("from Events ").list();
        session.getTransaction().commit();
        return eventList;
    }


    //delete Event
    public void deleteEvent(int id){
        Events event;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        event = session.find(Events.class, id);
        if (event != null){
            session.delete(event);
            session.flush();
            System.out.println("Event delete");

        }
        else{
            System.out.println("Event does not exist");
        }
        session.getTransaction().commit();
    }


    //update Event
    public Events updateEvent(Events t){
        Events events;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        events = session.find(Events.class, t.getId());
        if (events != null){
            events.setTypeEvent(t.getTypeEvent());
            events.setDescription(t.getDescription());
            events.setDateDebut(t.getDateDebut());
            events.setDeteFin(t.getDeteFin());
            events.setRelated(t.getRelated());
            events.setElement(t.getElement());
            System.out.println("Event update");
        }
        else{
            System.out.println("Event does not exist");
        }
        session.getTransaction().commit();

        return events;
    }
}
