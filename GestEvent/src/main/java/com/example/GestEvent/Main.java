package com.example.GestEvent;

import com.example.GestEvent.Modul.*;
import com.example.GestEvent.Services.ApprenantService;
import com.example.GestEvent.Services.FormateurService;
import com.example.GestEvent.Services.SpecialiteService;
import com.example.GestEvent.Services.UserService;
import org.hibernate.Session;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Users users = new Users("simo", "simo", "simo@gmail.com", "simo", Role.FORMATEUR);
//        Users users1 = new Users("mstf232", "mstf", "mstf@gmail.com", "mstf", Role.FORMATEUR);
        UserService userService = new UserService();
        userService.addUser(users);
//        userService.addUser(users1);

//        UserService userService = new UserService();
//        //getByElmail
//        Users users = userService.getUserByEmail("");
//        users.showUsers();




        //userService.deleteUser(4);
//        Iterator<Users> user = userService.getAllUsers().iterator();
//        while (user.hasNext()){
//            Users users = user.next();
//            users.showUsers();
//        }

//        Users users1 = new Users(5,"simo", "simo", "simo@gmail.com", "123", Role.FORMATEUR);
//        userService.updateUser(users1);
//




        Specialite specialite = new Specialite(1, "C#");
//        SpecialiteService sp = new SpecialiteService();
//        sp.updateSpecialite(specialite);
//
//        ApprenantService ap = new ApprenantService();
//        Apprenant a = new Apprenant(users,  specialite);
//        Apprenant b = new Apprenant(users1,  specialite);
//        ap.addApprenant(a);
//        ap.addApprenant(b);


        FormateurService f = new FormateurService();
        Formateur formateur = new Formateur(users, specialite);
        f.addFormateur(formateur);

    }
}
