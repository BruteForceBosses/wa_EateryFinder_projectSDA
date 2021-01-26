package com.eateryfinderwebapp.eateryfinderwebapp.service.impl;

import com.eateryfinderwebapp.eateryfinderwebapp.repository.InMemoryLocationsRepository;
import com.eateryfinderwebapp.eateryfinderwebapp.service.LocationService;
import com.eateryfinderwebapp.eateryfinderwebapp.models.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final InMemoryLocationsRepository locationsRepository;

    public LocationServiceImpl(InMemoryLocationsRepository locationsRepository) {
        this.locationsRepository = locationsRepository;
    }

    @Override
    public List<Location> listAllLocations() {
        return locationsRepository.getAllLocations();
    }

    @Override
    public List<Location> get5NearestLocations() {
        return locationsRepository.FindNearest5Locations();
    }

    @Override
    public void CreateURL(double latitude, double longitude, Location endPoint) {
        locationsRepository.CreateURL(latitude, longitude, endPoint);
    }

    @Override
    public void CreateURL(String latitude, String longitude, Location endPoint) {
        locationsRepository.CreateURL(latitude, longitude, endPoint);
    }

    //@Override
    //public void setUserLocation(double latitude, double longitude) {
    //    locationsRepository.setUserLatitude(latitude);
    //    locationsRepository.setUserLongitude(longitude);
    //}

    /*@Override
    public void getUserLocation() throws IOException {
        locationsRepository.getUserLocation();
    }*/


    @Override
    public double getUserLatitude() {
        return locationsRepository.getUserLatitude();
    }

    @Override
    public double getUserLongitude() {
        return locationsRepository.getUserLongitude();
    }

    @Override
    public void setUserLatitude(double latitude) {
        locationsRepository.setUserLatitude(latitude);
    }

    @Override
    public void setUserLongitude(double longitude) {
        locationsRepository.setUserLongitude(longitude);
    }
}
