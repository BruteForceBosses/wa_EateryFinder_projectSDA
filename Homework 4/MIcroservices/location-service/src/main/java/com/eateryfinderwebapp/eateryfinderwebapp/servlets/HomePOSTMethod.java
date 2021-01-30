package com.eateryfinderwebapp.eateryfinderwebapp.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomePOSTMethod implements Method{
    @Override
    public void doMethod(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/search");
    }
}
