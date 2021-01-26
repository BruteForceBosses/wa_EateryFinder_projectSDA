package com.eateryfinderwebapp.eateryfinderwebapp.repository;

import com.eateryfinderwebapp.eateryfinderwebapp.webscraper.WebScraper;

import com.eateryfinderwebapp.eateryfinderwebapp.models.Location;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryLocationsRepository {

    private static List<Location> locations = new ArrayList<Location>();
    private double userLatitude;
    private double userLongitude;


    @PostConstruct
    public void init(){
        WebScraper webScraper = new WebScraper();
        locations = webScraper.getLocations();
    }

    public List<Location> getAllLocations(){
        return locations;
    }

    private double Distance(double lat1, double lon1, double lat2, double lon2){
        double R = 6371e3; // metres
        double φ1 = lat1 * Math.PI/180; // φ, λ in radians
        double φ2 = lat2 * Math.PI/180;
        double Δφ = (lat2-lat1) * Math.PI/180;
        double Δλ = (lon2-lon1) * Math.PI/180;

        double a = Math.sin(Δφ/2) * Math.sin(Δφ/2) +
                Math.cos(φ1) * Math.cos(φ2) *
                        Math.sin(Δλ/2) * Math.sin(Δλ/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        double d = R * c; // in metres
        return d;
    }


    public List<Location> FindNearest5Locations(){
        for (int i=0; i<locations.size(); i++){
            locations.get(i).setDistance(Distance(userLatitude, userLongitude, locations.get(i).getLatitude(), locations.get(i).getLongitude()));
        }
        return locations.stream().sorted(Comparator.comparing(Location::getDistance)).limit(5).collect(Collectors.toList()); //you might have to reverse the order before selecting 5
    }

    public void CreateURL(double startLat,
                            double startLong,
                            Location endPoint){
        String startLatStr = Double.toString(startLat);
        String startLongStr = Double.toString(startLong);
        String endLatStr = Double.toString(endPoint.getLatitude());
        String endLongStr = Double.toString(endPoint.getLongitude());

        endPoint.setNavigationLink(String.format("https://www.openstreetmap.org/directions?engine=fossgis_osrm_car&route=%s%%2C%s%%3B%s%%2C%s", startLatStr,startLongStr, endLatStr, endLongStr));
    }

    public void CreateURL(String startLat,
                            String startLong,
                            Location endPoint){
        String endLatStr = Double.toString(endPoint.getLatitude());
        String endLongStr = Double.toString(endPoint.getLongitude());
        endPoint.setNavigationLink(String.format("https://www.openstreetmap.org/directions?engine=fossgis_osrm_car&route=%s%%2C%s%%3B%s%%2C%s", startLat,startLong, endLatStr, endLongStr));
    }

    /*public void getUserLocation() throws IOException {
        Document doc = Jsoup.connect("http://localhost:9090/search").get();
        userLatitude = Double.parseDouble(doc.getElementById("latitude").text());
        System.out.println(doc.getElementById("latitude").text());
        userLongitude = Double.parseDouble(doc.getElementById("longitude").text());
        System.out.println(doc.getElementById("longitude").text());

    }*/

    public double getUserLatitude() {
        return userLatitude;
    }

    public double getUserLongitude() {
        return userLongitude;
    }

    public void setUserLatitude(double userLatitude) {
        this.userLatitude = userLatitude;
    }

    public void setUserLongitude(double userLongitude) {
        this.userLongitude = userLongitude;
    }
}
