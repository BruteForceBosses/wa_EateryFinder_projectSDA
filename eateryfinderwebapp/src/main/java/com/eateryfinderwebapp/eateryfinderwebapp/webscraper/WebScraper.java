package com.eateryfinderwebapp.eateryfinderwebapp.webscraper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.eateryfinderwebapp.eateryfinderwebapp.models.Location;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WebScraper {
//Connect to database and go through every single osm_id and add longitude and latitude to them

    List<Location> locations;

    public WebScraper(){
        locations = new ArrayList<>();
    }

    static String [] nodes = {
           "577538728","1132688809","1475328750","1475388232","1748017584","1751563134","1752178268","1985948203","2883877896","3341289789",
    "3484100384","3505013893","3506695093","3830455732","3932033588","4016557277","4016557278","4101107990","4239053639","4327921318","4346542839","5548809221",
    "4436534289","4471884330","4720703993","496423190","5131817487","5074216083","5184727125","5224224121","5268700370","176448667","5292130848","5467884712",
    "5626433457","5692608680","5770427174","5830234866","6102488864","6268687385","6275187295","6586691822","6054049801","6814231688","6814231700","6814231702",
    "6814231793","6814236587","6814236621","6814245589","6814246691","6814246724","6815918386","6815931392","6821158588","4149490289","6827032731","6827032733",
    "5360062","6830542186"
    };

    public List<Location> getLocations(){
        try {

            // Here we create a document object and use JSoup to fetch the website
            for (int i=0; i<nodes.length; i++){
                String node = nodes[i];
                Document doc = Jsoup.connect("https://www.openstreetmap.org/node/"+node).get();

                // With the document fetched, we use JSoup's title() method to fetch the title

                String fullName = doc.getElementsByTag("bdi").text();
                String parts[] = fullName.split("\\s+");
                String name = "";
                String osm_id = "";
                for (int j=0; j<parts.length; j++){
                    if (j<parts.length - 2){
                        name+=parts[j] + " ";
                    }
                    else if(j<parts.length - 1)
                    {
                        name+=parts[j];
                    }
                    else {
                        osm_id=parts[j];
                    }
                }

                double latitude = Double.parseDouble(doc.getElementsByClass("latitude").text());
                double longitude = Double.parseDouble(doc.getElementsByClass("longitude").text());
                Location location = new Location( Double.parseDouble(osm_id), name, latitude, longitude);
                locations.add(location);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return locations;
    }

}
