package com.example.GestEvent.Servlet;

import com.example.GestEvent.Modul.Formateur;
import com.example.GestEvent.Modul.Role;
import com.example.GestEvent.Modul.Specialite;
import com.example.GestEvent.Modul.Users;
import com.example.GestEvent.Services.FormateurService;
import com.example.GestEvent.Services.SpecialiteService;
import com.example.GestEvent.Services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "addFormateurServlet", value = "/AddFormateur")
public class addFormateurServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SpecialiteService s = new SpecialiteService();
        request.setAttribute("specialite", s.getAllSpecialite());
        request.getRequestDispatcher("/WEB-INF/AddFormateur.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fn = request.getParameter("fn");
        String ln = request.getParameter("ln");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String sp = request.getParameter("specialite");


        //add user
        Users users = new Users(fn, ln ,email, pass, Role.FORMATEUR);
        UserService userService = new UserService();
        userService.addUser(users);

        //get specialite
        SpecialiteService specialiteService = new SpecialiteService();
        Specialite specialite = specialiteService.getSpecialiteByName(sp);
        specialite.showSpecialite();

        //add formateur
        Formateur formateur = new Formateur(users, specialite);
        formateur.showFormateur();
        FormateurService fr = new FormateurService();
        fr.addFormateur(formateur);
        response.sendRedirect("Formateur");
    }
}
