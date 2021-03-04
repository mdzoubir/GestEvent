package com.example.GestEvent.Servlet;

import com.example.GestEvent.Services.ApprenantService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ApprenantServlet", value = "/Apprenant")
public class ApprenantServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApprenantService apprenant = new ApprenantService();
        request.setAttribute("apprenant", apprenant.getAllApprenant());
        request.getRequestDispatcher("/WEB-INF/Apprenant.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
