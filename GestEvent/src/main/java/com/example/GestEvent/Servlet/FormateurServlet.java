package com.example.GestEvent.Servlet;

import com.example.GestEvent.Services.FormateurService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FormateurServlet", value = "/Formateur")
public class FormateurServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FormateurService formateur = new FormateurService();
        request.setAttribute("formateur", formateur.getAllFormateur());
        request.getRequestDispatcher("/WEB-INF/Formateur.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
