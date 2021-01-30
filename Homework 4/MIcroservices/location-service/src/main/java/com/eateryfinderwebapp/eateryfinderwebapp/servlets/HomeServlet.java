package com.eateryfinderwebapp.eateryfinderwebapp.servlets;

import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="homeservlet",urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    Method postMethod;
    Method getMethod;
    public HomeServlet(SpringTemplateEngine springTemplateEngine){
        getMethod=new GETMethod("home.html",springTemplateEngine);
        postMethod=new HomePOSTMethod();
    }
    //Here we redirect the user to the home page
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getMethod.doMethod(req,resp);
    }
    //Here we redirect the user to the search page
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        postMethod.doMethod(req, resp);
    }
}
