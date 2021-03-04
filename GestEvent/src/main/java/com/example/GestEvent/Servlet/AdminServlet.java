package com.example.GestEvent.Servlet;

import com.example.GestEvent.Modul.Role;
import com.example.GestEvent.Services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminServlet", value = "/Admin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService user = new UserService();
        request.setAttribute("user", user.getAllUsers());
        request.setAttribute("admin", Role.ADMIN);
        request.getRequestDispatcher("/WEB-INF/Admin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
