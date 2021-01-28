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
   public void CreateURL(double startLat,
                         double startLong,
                         Location endPoint){
       String startLatStr = Double.toString(startLat);
       String startLongStr = Double.toString(startLong);
       String endLatStr = Double.toString(endPoint.getLatitude());
       String endLongStr = Double.toString(endPoint.getLongitude());

       endPoint.setNavigationLink(String.format("https://www.openstreetmap.org/directions?engine=fossgis_osrm_car&route=%s%%2C%s%%3B%s%%2C%s", startLatStr,startLongStr, endLatStr, endLongStr));
   }
   @Override
    public void CreateURL(String startLat,
                          String startLong,
                          Location endPoint){
        String endLatStr = Double.toString(endPoint.getLatitude());
        String endLongStr = Double.toString(endPoint.getLongitude());
        endPoint.setNavigationLink(String.format("https://www.openstreetmap.org/directions?engine=fossgis_osrm_car&route=%s%%2C%s%%3B%s%%2C%s", startLat,startLong, endLatStr, endLongStr));
    }

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
