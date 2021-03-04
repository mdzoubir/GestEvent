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

@WebServlet(name = "UpdateFormateurServlet", value = "/UpdateFormateur")
public class UpdateFormateurServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //formateur id
        int idFormateur = Integer.parseInt(request.getParameter("idFormateur"));
        request.setAttribute("FormateurId", idFormateur);


        //id user
        int idUser = Integer.parseInt(request.getParameter("idUser"));
        request.setAttribute("idUser", idUser);


        //get all specialite
        SpecialiteService s = new SpecialiteService();
        request.setAttribute("specialite", s.getAllSpecialite());

        //get formateur by id
        FormateurService formateurService = new FormateurService();
        Formateur formateur = formateurService.getFormateurById(idFormateur);
        request.setAttribute("formateur", formateur);
        request.getRequestDispatcher("/WEB-INF/UpdateFormateur.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fn = request.getParameter("fn");
        String ln = request.getParameter("ln");
        String email = request.getParameter("email");
        int id = Integer.parseInt(request.getParameter("id"));
        String pass = request.getParameter("pass");
        String specialite = request.getParameter("specialite");
        int iduser = Integer.parseInt(request.getParameter("iduser"));


        //update User
        UserService userService = new UserService();
        Users users = new Users(iduser, fn, ln, email, pass, Role.FORMATEUR);
        userService.updateUser(users);

        //get Objet specialite
        SpecialiteService specialiteService = new SpecialiteService();
        Specialite specialite1 = specialiteService.getSpecialiteByName(specialite);


        FormateurService formateurService = new FormateurService();
        Formateur formateur = new Formateur(id, users, specialite1);
        formateurService.updateFormateur(formateur);
        response.sendRedirect("Formateur");


    }
}
