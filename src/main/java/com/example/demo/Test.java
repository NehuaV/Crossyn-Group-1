package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;

public class Test {
    public static void main(String[] args) throws Exception {

        // HTTP Get request - Uses Stringify method to make custom URL with provided coordinates
        URL request = new URL(Stringify("51.59143","4.77158"));

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
        JSONObject temp = myResponse.getJSONArray("results").getJSONObject(0);
        String result = temp.getString("formatted_address");
        System.out.println(result);


    }

    // API Key and Coordinates method
    public static String Stringify(String lat,String lon){
        String key= "AIzaSyAj3JM4M64fttwnz7rnyi7SgWKzZUpgcGU";
        return "https://maps.googleapis.com/maps/api/geocode/json?latlng="+lat+","+lon+"&key="+key;
    }

}
