package com.eateryfinderwebapp.eateryfinderwebapp.servlets;

import com.eateryfinderwebapp.eateryfinderwebapp.service.LocationService;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="resultsservlet",urlPatterns = "/results")
public class ResultsServlet extends HttpServlet {
    Method getMethod;
    public ResultsServlet(SpringTemplateEngine springTemplateEngine, LocationService locationService) {
        getMethod=new ResultsGETMethod("results.html",springTemplateEngine, locationService);
    }
    //Here we redirect the user to the results page
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getMethod.doMethod(req,resp);
    }


}
