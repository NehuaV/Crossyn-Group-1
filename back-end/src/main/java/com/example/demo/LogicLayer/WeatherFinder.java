package com.example.demo.LogicLayer;

import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;

public class WeatherFinder {
    //Finds the weather information for the trip. Uses OpenWeatherMap api.
    private String key = "d244fcd585887ac4fa59258fdfcb56c2";

    private String Stringify(String lat,String lon, String unixtime){
    return "http://history.openweathermap.org/data/2.5/history/city?lat="+lat+"&lon="+lon+"&type=hour&start="+unixtime+"&cnt=1&appid="+key;
    }

    public String FindWeather(String lat, String lon,String unixtime) throws IOException {
        String key = "";
        URL request = new URL( Stringify(lat,lon,unixtime));

        // Open Connection
        URLConnection rq = request.openConnection();

        // Save Returned Data in inputLine
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        rq.getInputStream()));
        String inputLine;

        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null)
            response.append(inputLine);

        // Close Connection - Important!
        in.close();

        // Convert the String response into a JSON object
        JSONObject myResponse = new JSONObject(response.toString().trim());
        JSONObject temp = myResponse.getJSONArray("list").getJSONObject(0);
        String  description = temp.getJSONArray("weather").getJSONObject(0).getString("description");
        double temperature = temp.getJSONObject("main").getDouble("temp") - 273.15;
        String weather_desc = String.format("%1$,.2f",temperature)+ "°C, with " + description;
        return weather_desc;
    }
}
