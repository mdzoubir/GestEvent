package com.example.GestEvent.Services;

import com.example.GestEvent.HibernateUtil;
import com.example.GestEvent.Modul.Formateur;
import com.example.GestEvent.Modul.Users;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class FormateurService {
    Session session;

    public void addFormateur(Formateur formateur) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(formateur);
        session.getTransaction().commit();
        System.out.println("add formateur");
    }
    public Formateur getFormateurById(int id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Formateur formateur = session.find(Formateur.class, id);
        session.getTransaction().commit();
        return formateur;
    }

    public List<Formateur> getAllFormateur() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Formateur> formateurList = session.createQuery("from Formateur ").list();
        session.getTransaction().commit();
        return formateurList;
    }

    public void deleteFormateur(int id){
        Formateur formateur;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        formateur = session.find(Formateur.class, id);
        if (formateur != null){
            session.delete(formateur);
            session.flush();
            System.out.println("User formateur");

        }
        else{
            System.out.println("formateur does not exist");
        }
        session.getTransaction().commit();
    }

    public Formateur updateFormateur(Formateur formateur){
        Formateur formateurs;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        formateurs = session.find(Formateur.class, formateur.getIdFormatur());
        if (formateurs != null){
            formateurs.setIdusers(formateur.getIdusers());
            formateurs.setIdSpecialite(formateur.getIdSpecialite());
            System.out.println("formateur update");

        }
        else{
            System.out.println("formateur does not exist");
        }
        session.getTransaction().commit();


        return formateurs;
    }

}
