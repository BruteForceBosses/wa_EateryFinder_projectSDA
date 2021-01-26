package com.eateryfinderwebapp.eateryfinderwebapp.servlets;


import com.eateryfinderwebapp.eateryfinderwebapp.service.LocationService;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="searchservlet",urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    Method postMethod;
    Method getMethod;
    public SearchServlet(SpringTemplateEngine springTemplateEngine, LocationService locationService) {
        postMethod=new SearchPOSTMethod("/results",locationService);
        getMethod=new GETMethod("search.html",springTemplateEngine);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getMethod.doMethod(req,resp);
    }
    //Here we redirect the user to the results page
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        postMethod.doMethod(req,resp);
    }
}
