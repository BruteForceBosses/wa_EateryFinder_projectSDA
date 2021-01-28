package com.eateryfinderwebapp.eateryfinderwebapp.servlets;

import com.eateryfinderwebapp.eateryfinderwebapp.service.LocationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SearchPOSTMethod implements Method{
    private String parameter;
    private final LocationService locationService;
    public SearchPOSTMethod(String parameter, LocationService locationService){
        this.parameter=parameter;
        this.locationService=locationService;
    }
    @Override
    public void doMethod(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String latitude = req.getParameter("latitude");
        String longitude = req.getParameter("longitude");
        locationService.setUserLatitude(Double.parseDouble(latitude));
        locationService.setUserLongitude(Double.parseDouble(longitude));
        resp.sendRedirect(parameter);
    }
}
