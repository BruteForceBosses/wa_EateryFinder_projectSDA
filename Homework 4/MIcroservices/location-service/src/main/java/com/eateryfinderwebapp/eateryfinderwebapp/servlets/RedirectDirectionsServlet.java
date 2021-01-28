package com.eateryfinderwebapp.eateryfinderwebapp.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="redirectdirectionsservlet", urlPatterns = "/redirectdirections")
public class RedirectDirectionsServlet extends HttpServlet{
    Method postMethod=new RedirectPOSTMethod("directionsurl");
    //Here we redirect the user to the directions to the desired eatery on OpenStreetMap
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        postMethod.doMethod(req,resp);
    }
}
