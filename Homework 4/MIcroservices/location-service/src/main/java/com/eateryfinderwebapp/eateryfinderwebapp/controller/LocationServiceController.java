package com.eateryfinderwebapp.eateryfinderwebapp.controller;

import com.eateryfinderwebapp.eateryfinderwebapp.service.LocationService;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@WebServlet(name="resultsservlet",urlPatterns = "/results")
public class LocationServiceController extends HttpServlet {
    private final LocationService locationService;
    private final SpringTemplateEngine springTemplateEngine;
    public LocationServiceController(LocationService locationService, SpringTemplateEngine springTemplateEngine){
        this.locationService=locationService;
        this.springTemplateEngine=springTemplateEngine;
    }
    //Here we redirect the user to the results page
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req,resp,req.getServletContext());
        context.setVariable("locations", locationService.get5NearestLocations());
        context.setVariable("userlatitude", locationService.getUserLatitude());
        context.setVariable("userlongitude", locationService.getUserLongitude());
        this.springTemplateEngine.process("results.html",context,resp.getWriter());
    }
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}