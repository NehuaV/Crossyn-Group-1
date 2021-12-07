package com.example.demo.LogicLayer;

import com.example.demo.LogicLayer.ILogicLayer.IAddressFinder;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@Service
public class AddressFinder implements IAddressFinder {

//    private String key = "AIzaSyAj3JM4M64fttwnz7rnyi7SgWKzZUpgcGU";

    // Coordinates link generator
    // Does not require api key since Nominatim is open source
    private String Stringify(String lat, String lon) {
        return "https://nominatim.openstreetmap.org/reverse?format=jsonv2&accept-language=en-US&lat=" + lat + "&lon=" + lon;
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
        JSONObject temp = myResponse.getJSONObject("address");
        // Save all needed fields to string
        String result = temp.getString("road") + " " + temp.getString("postcode") + " " + temp.getString("city");
        // Return address String
        return result;
    }
}
