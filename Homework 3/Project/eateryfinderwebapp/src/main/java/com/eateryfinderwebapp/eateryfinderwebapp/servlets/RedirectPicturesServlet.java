package com.eateryfinderwebapp.eateryfinderwebapp.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="redirectpicturesservlet", urlPatterns = "/redirectpictures")
public class RedirectPicturesServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getParameter("picturesurl");
        resp.sendRedirect(url);
    }
}
