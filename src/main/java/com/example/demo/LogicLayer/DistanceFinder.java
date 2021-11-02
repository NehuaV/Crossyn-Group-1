package com.example.demo.LogicLayer;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class DistanceFinder {
    private String key= "AIzaSyAj3JM4M64fttwnz7rnyi7SgWKzZUpgcGU";

    private String Stringify(String lat_origin,String lon_origin,String lat_destination, String lon_destination){
        return "https://maps.googleapis.com/maps/api/distancematrix/json?origins="+lat_origin+","+lon_origin+"&destinations="+lat_destination+","+lon_destination+"&key="+key;
    }
    public String FindDistance(String lat_origin,String lon_origin,String lat_destination, String lon_destination) throws IOException {

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
        String result = temp2.getJSONObject("distance").getString("text").toString();
        System.out.println(result);
        return result;
    }
}
