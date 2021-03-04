package com.example.GestEvent.Servlet;

import com.example.GestEvent.Services.ApprenantService;
import com.example.GestEvent.Services.FormateurService;
import com.example.GestEvent.Services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SupApprenantServlet", value = "/SupApprenant")
public class SupApprenantServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int idAppr = Integer.parseInt(request.getParameter("idAppr"));


        //delete formateur
        ApprenantService apprenantService = new ApprenantService();
        apprenantService.deleteApprenant(idAppr);

        //delete user
        UserService userService = new UserService();
        userService.deleteUser(id);


        response.sendRedirect("Apprenant");
    }
}
