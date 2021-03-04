package com.example.GestEvent.Servlet;

import com.example.GestEvent.Modul.Role;
import com.example.GestEvent.Modul.Users;
import com.example.GestEvent.Services.SpecialiteService;
import com.example.GestEvent.Services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "addAdminServlet", value = "/addAdmin")
public class addAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/AddAdmin.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fn = request.getParameter("fn");
        String ln = request.getParameter("ln");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        Users users = new Users(fn, ln, email, pass, Role.ADMIN);
        UserService usersServlet = new UserService();
        usersServlet.addUser(users);
        response.sendRedirect("Admin");
    }
}
