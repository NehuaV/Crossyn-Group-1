package com.example.demo.LogicLayer;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class AddressFinder {

    private String key = "AIzaSyAj3JM4M64fttwnz7rnyi7SgWKzZUpgcGU";

    // API Key and Coordinates link generator
    private String Stringify(String lat, String lon) {
        return "https://maps.googleapis.com/maps/api/geocode/json?latlng=" + lat + "," + lon + "&key=" + key;
    }

    public String FindAddress(String lat, String lon) throws IOException, JSONException {

        // HTTP Get request - Uses Stringify method to make custom URL with provided coordinates
        URL request = new URL(Stringify(lat, lon));

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
        //System.out.println(result);
        return result;
    }
}
