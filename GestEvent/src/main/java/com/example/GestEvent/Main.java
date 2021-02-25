package com.example.GestEvent;

import com.example.GestEvent.Modul.Role;
import com.example.GestEvent.Modul.Users;
import com.example.GestEvent.Services.UserService;
import org.hibernate.Session;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
//        Users users = new Users("mstf", "mstf", "mstf@gmail.com", "mstf", Role.FORMATEUR);
//        UserService userService = new UserService();
//        userService.addUser(users);

        UserService userService = new UserService();
        //getByElmail
        Users users = userService.getUserByEmail("");
        users.showUsers();




        //userService.deleteUser(4);
//        Iterator<Users> user = userService.getAllUsers().iterator();
//        while (user.hasNext()){
//            Users users = user.next();
//            users.showUsers();
//        }

//        Users users1 = new Users(5,"simo", "simo", "simo@gmail.com", "123", Role.FORMATEUR);
//        userService.updateUser(users1);
//
//        Users users = userService.getUserById(5);
//        users.showUsers();
    }
}
