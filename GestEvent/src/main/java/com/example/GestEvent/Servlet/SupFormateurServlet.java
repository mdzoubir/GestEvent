package com.example.GestEvent.Servlet;

import com.example.GestEvent.Services.FormateurService;
import com.example.GestEvent.Services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SupFormateurServlet", value = "/SupFormateur")
public class SupFormateurServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int idFormateur = Integer.parseInt(request.getParameter("idFormateur"));


        //delete formateur
        FormateurService formateurService = new FormateurService();
        formateurService.deleteFormateur(idFormateur);

        //delete user
        UserService userService = new UserService();
        userService.deleteUser(id);


        response.sendRedirect("Formateur");
    }
}
