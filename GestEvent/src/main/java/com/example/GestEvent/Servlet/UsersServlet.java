package com.example.GestEvent.Servlet;

import com.example.GestEvent.Modul.Apprenant;
import com.example.GestEvent.Modul.Role;
import com.example.GestEvent.Services.ApprenantService;
import com.example.GestEvent.Services.FormateurService;
import com.example.GestEvent.Services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UsersServlet", value = "/Users")
public class UsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService user = new UserService();
        ApprenantService apprenant = new ApprenantService();
        FormateurService formateur = new FormateurService();
        request.setAttribute("user", user.getAllUsers());
        request.setAttribute("apprenant", apprenant.getAllApprenant());
        request.setAttribute("formateur", formateur.getAllFormateur());
        request.setAttribute("admin", Role.ADMIN);
        request.getRequestDispatcher("/WEB-INF/Users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
