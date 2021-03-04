package com.example.GestEvent.Servlet;

import com.example.GestEvent.Modul.Role;
import com.example.GestEvent.Modul.Users;
import com.example.GestEvent.Services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateAdminServlet", value = "/UpdateAdmin")
public class UpdateAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        UserService userService = new UserService();
        Users users = userService.getUserById(id);
        request.setAttribute("users", users);
        request.getRequestDispatcher("/WEB-INF/UpdateAdmin.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fn = request.getParameter("fn");
        String ln = request.getParameter("ln");
        String email = request.getParameter("email");
        int id = Integer.parseInt(request.getParameter("id"));
        String pass = request.getParameter("pass");


        //update admin
        UserService userService = new UserService();
        Users users = new Users(id, fn, ln, email, pass, Role.ADMIN);
        userService.updateUser(users);
        response.sendRedirect("Admin");
    }
}
