package com.eateryfinderwebapp.eateryfinderwebapp.models;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Location {
    private double osm_id;
    private String name;
    private double longitude;
    private double latitude;
    private double distance;
    private String navigationLink;

    public Location(double osm_id, String name, double latitude, double longitude) {
        this.osm_id = osm_id;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.distance = 0;
        this.navigationLink = null;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getOsm_id() {
        return osm_id;
    }

    public String getName() {
        return name;
    }

    public void setOsm_id(double osm_id) {
        this.osm_id = osm_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getNavigationLink() {
        return navigationLink;
    }

    public void setNavigationLink(String navigationLink) {
        this.navigationLink = navigationLink;
    }

    public String getNavigationLink(double startLat,
                                  double startLong) {
        String startLatStr = Double.toString(startLat);
        String startLongStr = Double.toString(startLong);
        String endLatStr = Double.toString(latitude);
        String endLongStr = Double.toString(longitude);

        return navigationLink = String.format("https://www.openstreetmap.org/directions?engine=fossgis_osrm_car&route=%s%%2C%s%%3B%s%%2C%s", startLatStr, startLongStr, endLatStr, endLongStr);
    }

    public String getNavigationLink(String startLat,
                                  String startLong){
        String endLatStr = Double.toString(latitude);
        String endLongStr = Double.toString(longitude);
        return navigationLink = String.format("https://www.openstreetmap.org/directions?engine=fossgis_osrm_car&route=%s%%2C%s%%3B%s%%2C%s", startLat,startLong, endLatStr, endLongStr);
    }

        @Override
    public String toString() {
        return String.format("%.0f,%s,%f,%f", osm_id, name, latitude, longitude);
    }

    public String getPicturesLink(){
        String query="";
        String [] name = this.name.split("\\s+");
        for(int i=0; i<name.length - 1; i++){
            query+=name[i]+"+";
        }
        query+=name[name.length-1]+"&";
        return String.format("https://www.google.com/search?q=%stbm=isch", query);
    }

    public String getInfoLink(){
        String query="";
        String [] name = this.name.split("\\s+");
        for(int i=0; i<name.length - 1; i++){
            query+=name[i]+"+";
        }
        query+=name[name.length-1];
        return String.format("https://www.google.com/search?q=%s", query);
    }
}
