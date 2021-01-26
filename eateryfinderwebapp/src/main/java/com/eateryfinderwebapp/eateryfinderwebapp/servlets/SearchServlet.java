package com.eateryfinderwebapp.eateryfinderwebapp.servlets;


import com.eateryfinderwebapp.eateryfinderwebapp.service.LocationService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="searchservlet",urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final LocationService locationService;

    public SearchServlet(SpringTemplateEngine springTemplateEngine, LocationService locationService) {
        this.springTemplateEngine = springTemplateEngine;
        this.locationService = locationService;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req,resp,req.getServletContext());
        this.springTemplateEngine.process("search.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String latitude = req.getParameter("latitude");
        String longitude = req.getParameter("longitude");
        locationService.setUserLatitude(Double.parseDouble(latitude));
        locationService.setUserLongitude(Double.parseDouble(longitude));
        resp.sendRedirect("/results");
    }
}
