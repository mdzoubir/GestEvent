package com.example.GestEvent.Services;

import com.example.GestEvent.HibernateUtil;
import com.example.GestEvent.Modul.Specialite;
import com.example.GestEvent.Modul.Users;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class SpecialiteService {
    Session session;

    //add specialite
    public void addSpecialite(Specialite s) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(s);
        session.getTransaction().commit();
        System.out.println("add Specialite");
    }


    //get Specialite by id
    public Specialite getSpecialiteById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Specialite specialite = session.find(Specialite.class, id);
        session.getTransaction().commit();
        return specialite;
    }

    // get specialite list
    public List<Specialite> getAllSpecialite() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List listSpecialite = session.createQuery("from Specialite").list();
        session.getTransaction().commit();
        return listSpecialite;
    }

    //delete specialite
    public void deleteSpecialite(int id){
        Specialite specialite;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        specialite = session.find(Specialite.class, id);
        if (specialite != null){
            session.delete(specialite);
            session.flush();
            System.out.println("Specialite delete");

        }
        else{
            System.out.println("Specialite does not exist");
        }
        session.getTransaction().commit();
    }

    //Update Specialite
    public Specialite updateSpecialite(Specialite s){
        Specialite specialite;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        specialite = session.find(Specialite.class, s.getId_specialite());
        if (specialite != null){
            specialite.setNomSpecialite(s.getNomSpecialite());
            System.out.println("Specialite update");
        }
        else{
            System.out.println("Specialite does not exist");
        }
        session.getTransaction().commit();


        return specialite;
    }

    //get specailite by name
    public Specialite getSpecialiteByName(String name){
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query =  session.createQuery("from Specialite where nomSpecialite=: name");
        query.setParameter("name", name);
        try {
            Specialite specialite = (Specialite) query.getSingleResult();
            session.getTransaction().commit();
            return specialite;
        }
        catch (Exception e){
            return null;
        }

    }
}
