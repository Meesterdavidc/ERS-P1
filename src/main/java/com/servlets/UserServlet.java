package com.servlets;

import com.models.User;
import com.persistence.UserDAO;
import com.utils.CurrentUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {

    UserDAO userDAO= new UserDAO();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //    super.doGet(req, resp);

//        Integer userId= Integer.parseInt(req.getParameter("user-id-input"));
//        User myUser= userDAO.read(userId);
//
//        resp.getWriter().println(myUser.getFirst_name());
//        resp.getWriter().println(myUser.getLast_name());
//        resp.getWriter().println(myUser.getEmail());
//        System.out.println(resp.getStatus()+ "here we are printing the response code");



        String email= String.valueOf(req.getParameter("email-sign-in"));
        String password= String.valueOf(req.getParameter("password-sign-in"));

        CurrentUser.currentUser= userDAO.LoginUser(email,password);

//this can be used to decipher between employee types
        // if(CurrentUser.employee== "employee"){

        // do some logic
        // } else{
        //do some other logic
        // }
        //this logic allows us to either take a user to his ticket page
        // if we create a html page specific for tickets
        //or if the login is wrong and there is no user
        //it can take you to your error-page.html

        // if(CurrentUser.currentUser== null){
        //   req.getRequestDispatcher("error-page.html");
        //
        //
        // }else{
        // req.getRequestDispatcher("tickets.html");
        // }


        // Here I am redirecting the client to the welcome.html page.
        req.getRequestDispatcher("welcome.html").forward(req,resp);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  super.doPost(req, resp);


        String FirstName=String.valueOf(req.getParameter("FirstName-input"));
        String LastName=String.valueOf(req.getParameter("LastName-input"));
        String email= String.valueOf(req.getParameter("email-input"));



        User newUser= new User(FirstName,LastName,email);
        userDAO.create(newUser);


        resp.setStatus((203));


        req.getRequestDispatcher("index.html").forward(req,resp);


    }
}
