package com.eateryfinderwebapp.eateryfinderwebapp.servlets;

import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GETMethod implements Method{
    private String parameter;
    private final SpringTemplateEngine springTemplateEngine;
    public GETMethod(String parameter, SpringTemplateEngine springTemplateEngine){
        this.parameter=parameter;
        this.springTemplateEngine=springTemplateEngine;
    }
    @Override
    public void doMethod(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req,resp,req.getServletContext());
        this.springTemplateEngine.process(parameter,context,resp.getWriter());
    }
}
