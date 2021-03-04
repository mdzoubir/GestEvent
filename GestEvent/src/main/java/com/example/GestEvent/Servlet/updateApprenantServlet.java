package com.example.GestEvent.Servlet;

import com.example.GestEvent.Modul.*;
import com.example.GestEvent.Services.ApprenantService;
import com.example.GestEvent.Services.FormateurService;
import com.example.GestEvent.Services.SpecialiteService;
import com.example.GestEvent.Services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "updateApprenantServlet", value = "/UpdateApprenantr")
public class updateApprenantServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //apprenant id
        int idApprenant = Integer.parseInt(request.getParameter("idApprenant"));
        request.setAttribute("idApprenant", idApprenant);


        //id user
        int idUser = Integer.parseInt(request.getParameter("idUser"));
        request.setAttribute("idUser", idUser);


        //get all specialite
        SpecialiteService s = new SpecialiteService();
        request.setAttribute("specialite", s.getAllSpecialite());

        //get formateur by id
        ApprenantService apprenantService = new ApprenantService();
        Apprenant apprenant = apprenantService.getApprenantById(idApprenant);
        request.setAttribute("apprenant", apprenant);
        request.getRequestDispatcher("/WEB-INF/UpdateApprenant.jsp").forward(request,response);
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
        Users users = new Users(iduser, fn, ln, email, pass, Role.APPRONANT);
        userService.updateUser(users);

        //get Objet specialite
        SpecialiteService specialiteService = new SpecialiteService();
        Specialite specialite1 = specialiteService.getSpecialiteByName(specialite);


        ApprenantService apprenantService = new ApprenantService();
        Apprenant apprenant = new Apprenant(id, users, specialite1);
        apprenantService.updateApprenant(apprenant);
        response.sendRedirect("Apprenant");
    }
}
