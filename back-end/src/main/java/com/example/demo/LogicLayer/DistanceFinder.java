package com.example.demo.LogicLayer;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class DistanceFinder {
    /*private String key= "AIzaSyAj3JM4M64fttwnz7rnyi7SgWKzZUpgcGU";

    private String Stringify(String lat_origin,String lon_origin,String lat_destination, String lon_destination){
        return "https://maps.googleapis.com/maps/api/distancematrix/json?origins="+lat_origin+","+lon_origin+"&destinations="+lat_destination+","+lon_destination+"&key="+key;
    }*/

    public double FindDistance (double lat1,double lon1, double lat2, double lon2, double height1, double height2)
    {
        //an API-less distance finder, using the haversine method and taking account of the elevation
        final int R = 6371;
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = height1 - height2;
        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);

    }
   /* public String FindDistance(String lat_origin,String lon_origin,String lat_destination, String lon_destination) throws IOException {

        // HTTP Get request - Uses Stringify method to make custom URL with provided coordinates
        URL request = new URL( Stringify(lat_origin,lon_origin,lat_destination,lon_destination));

        // Open Connection
        URLConnection rq = request.openConnection();

        // Save Returned Data in inputLine
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        rq.getInputStream()));
        String inputLine;

        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null)
            //System.out.println(inputLine);
            response.append(inputLine);

        // Close Connection - Important!
        in.close();

        // Convert the String response into a JSON object
        JSONObject myResponse = new JSONObject(response.toString());

        // Navigate through JSON object
        JSONObject temp = myResponse.getJSONArray("rows").getJSONObject(0);
        JSONObject temp2 = temp.getJSONArray("elements").getJSONObject(0);
        String result = temp2.getJSONObject("distance").getString("text").toString(); //grab distance output in km (string format)
        return result;
    }*/
}
