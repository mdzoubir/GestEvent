package com.example.GestEvent.Services;

import com.example.GestEvent.HibernateUtil;
import com.example.GestEvent.Modul.Apprenant;
import com.example.GestEvent.Modul.Specialite;
import com.example.GestEvent.Modul.Users;
import org.hibernate.Session;

import java.util.List;

public class ApprenantService {

    Session session;

    public void addApprenant(Apprenant apprenant) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(apprenant);
        session.getTransaction().commit();
        System.out.println("add apprenant");
    }

    public Apprenant getApprenantById(int id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Apprenant apprenant = session.find(Apprenant.class, id);
        session.getTransaction().commit();
        return apprenant;
    }

    public List<Apprenant> getAllApprenant() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Apprenant> apprenantList = session.createQuery("from Apprenant ").list();
        session.getTransaction().commit();
        return apprenantList;
    }


    //delete Apprenant
    public void deleteApprenant(int id){
        Apprenant apprenant;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        apprenant = session.find(Apprenant.class, id);
        if (apprenant != null){
            session.delete(apprenant);
            session.flush();
            System.out.println("Apprenant delete");

        }
        else{
            System.out.println("Apprenant does not exist");
        }
        session.getTransaction().commit();
    }


    //update Apprenant
    public Apprenant updateApprenant(Apprenant a){
        Apprenant apprenant;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        apprenant = session.find(Apprenant.class, a.getIdApprenant());
        if (apprenant != null){
            apprenant.setIdUsers(a.getIdUsers());
            apprenant.setIdSpecialite(a.getIdSpecialite());
            System.out.println("Apprenant update");
        }
        else{
            System.out.println("Apprenant does not exist");
        }
        session.getTransaction().commit();
        return apprenant;
    }

}
