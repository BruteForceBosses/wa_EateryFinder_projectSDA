package com.eateryfinderwebapp.eateryfinderwebapp.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="redirectinfoservlet", urlPatterns = "/redirectinfo")
public class RedirectInfoServlet extends HttpServlet{
    Method postMethod=new RedirectPOSTMethod("infourl");
    //Here we redirect the user to a google search of the desired eatery
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        postMethod.doMethod(req,resp);
    }
}
