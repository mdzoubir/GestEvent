package com.example.GestEvent.Servlet;

import com.example.GestEvent.Modul.Role;
import com.example.GestEvent.Modul.Users;
import com.example.GestEvent.Services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserService userService = new UserService();

        Users users = userService.getUserByEmail(email);
        if (users != null && users.getPassword().equals(password)){
            System.out.println("login");
            if (users.getRole().equals(Role.ADMIN)){
                request.setAttribute("user", users.getFirstName() + " " + users.getLastName());
                response.sendRedirect("Users");
            }
            else{
                System.out.println("hi");
            }
        }else {
            System.out.println("try again");
            request.setAttribute("message", "password or email is incorrect");
            request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);


    }
}
