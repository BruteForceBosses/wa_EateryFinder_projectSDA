package com.eateryfinderwebapp.eateryfinderwebapp.service;

import com.eateryfinderwebapp.eateryfinderwebapp.models.Location;

import java.util.List;

public interface LocationService {
    List<Location> listAllLocations();
    List<Location> get5NearestLocations();
    void CreateURL(double latitude, double longitude, Location endPoint);
    void CreateURL(String latitude, String longitude, Location endPoint);
    double getUserLatitude();
    double getUserLongitude();
    void setUserLatitude(double latitude);
    void setUserLongitude(double longitude);

}
