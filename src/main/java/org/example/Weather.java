package org.example;

import static spark.Spark.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Weather {
    private static double temperature; // Declared temperature to be used as a class field
    private  static String formattedTemperature; // class field to limit decimal places of temperature
    public static void main(String[] args) {
        port(8080);//port used by spark framework

        // Define a route to render the form
        get("/", (req, res) -> {
            return "<form action='/' method='post'>" +
                    "Enter the city name: <input type='text' name='username'>" +
                    "<input type='submit' value='Submit'>" +
                    "</form>";
        });

        // Define a route to handle form submission
        post("/", (req, res) -> {
            String city = req.queryParams("username");
            String apiKey = "d94a1a5aa3c285a26a3d45c0e357d771";
            String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;

            try {
                String jsonText=""; //this will contain the JSON response obtained from the openweather API call
                URL url=new URL(apiUrl);
                InputStream is=url.openStream();
                BufferedReader bufferReader=new BufferedReader(new InputStreamReader(is));
                String line;
                while((line=bufferReader.readLine())!=null){
                    jsonText+=line+"\n";
                }
                is.close();//closing the inputstream
                bufferReader.close();//closing the bufferreader
                 

                // Return the result in JSON
                return jsonText;

            } catch (IOException e) {
                e.printStackTrace();
                return "Error fetching temperature information";
            }
        });
    }


}
