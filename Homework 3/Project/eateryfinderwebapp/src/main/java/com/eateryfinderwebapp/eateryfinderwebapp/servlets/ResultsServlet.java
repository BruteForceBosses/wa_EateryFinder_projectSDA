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

@WebServlet(name="resultsservlet",urlPatterns = "/results")
public class ResultsServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final LocationService locationService;

    public ResultsServlet(SpringTemplateEngine springTemplateEngine, LocationService locationService) {
        this.springTemplateEngine = springTemplateEngine;
        this.locationService = locationService;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req,resp,req.getServletContext());
        context.setVariable("locations", locationService.get5NearestLocations());
        context.setVariable("userlatitude", locationService.getUserLatitude());
        context.setVariable("userlongitude", locationService.getUserLongitude());
        this.springTemplateEngine.process("results.html",context,resp.getWriter());
    }


}
