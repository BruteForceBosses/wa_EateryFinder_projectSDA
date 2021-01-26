package com.eateryfinderwebapp.eateryfinderwebapp.servlets;

import com.eateryfinderwebapp.eateryfinderwebapp.service.LocationService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResultsGETMethod implements Method{
    private String parameter;
    private final SpringTemplateEngine springTemplateEngine;
    private final LocationService locationService;
    public ResultsGETMethod(String parameter,SpringTemplateEngine springTemplateEngine,LocationService locationService){
        this.parameter=parameter;
        this.springTemplateEngine=springTemplateEngine;
        this.locationService=locationService;
    }
    @Override
    public void doMethod(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req,resp,req.getServletContext());
        context.setVariable("locations", locationService.get5NearestLocations());
        context.setVariable("userlatitude", locationService.getUserLatitude());
        context.setVariable("userlongitude", locationService.getUserLongitude());
        this.springTemplateEngine.process(parameter,context,resp.getWriter());
    }
}
