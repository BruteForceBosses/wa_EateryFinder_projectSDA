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
    "5360062","6830542186","310289760","411009859","459801246","459802458","1355292490","1355306911","1752184797","1850511013","1876583691",
    "1876584011","2814545377","2883877894","3663767994","3755532975","4059907155","4198944089","4225448689","4233194691","4234144690","4247226994",
            "4304451302","4327921320","4375519489","4511016243","4658223491","4846704245","5062450021","5110720231","5176248987","5284221296","5288522422",
    "5333583388","5534803022","5604182920","5622210754","5690140438","5690140660","5713714222","5841843563","5859233985","6054048726",
    "6054048730","6089711779","6145381755","6228007184","6307066053","8188528781","6451451785","6577887485","6680280012","6802029812",
    "6814231792","6814246723","6815559888","6815434689","6815925985","6815931391","6821158386","6821158388","6821158389","6821158695",
    "4744349444","6827074010","7119714585","7139002050"
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
