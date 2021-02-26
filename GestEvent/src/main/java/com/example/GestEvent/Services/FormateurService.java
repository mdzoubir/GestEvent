package com.example.GestEvent.Services;

import com.example.GestEvent.HibernateUtil;
import com.example.GestEvent.Modul.Apprenant;
import com.example.GestEvent.Modul.Formateur;
import org.hibernate.Session;

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


    //delete Formateur
    public void deleteFormateur(int id){
        Formateur formateur;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        formateur = session.find(Formateur.class, id);
        if (formateur != null){
            session.delete(formateur);
            session.flush();
            System.out.println("Formateur delete");

        }
        else{
            System.out.println("Formateur does not exist");
        }
        session.getTransaction().commit();
    }


    //update Formateur
    public Formateur updateFormateur(Formateur f){
        Formateur formateur;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        formateur = session.find(Formateur.class, f.getIdFormatur());
        if (formateur != null){
            formateur.setIdusers(f.getIdusers());
            formateur.setIdSpecialite(f.getIdSpecialite());
            System.out.println("Formateur update");

        }
        else{
            System.out.println("Formateur does not exist");
        }
        session.getTransaction().commit();

        return formateur;
    }
}
