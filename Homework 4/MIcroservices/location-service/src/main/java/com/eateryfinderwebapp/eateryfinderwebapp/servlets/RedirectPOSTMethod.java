package com.eateryfinderwebapp.eateryfinderwebapp.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectPOSTMethod implements Method{
    private String parameter;
    public RedirectPOSTMethod(String parameter){
        this.parameter=parameter;
    }
    @Override
    public void doMethod(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getParameter(parameter);
        resp.sendRedirect(url);
    }
}
