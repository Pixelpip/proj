package org.example;

import static spark.Spark.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Weather {
    public static void main(String[] args) {

        port(8080); // port used by spark framework

        // Define a route to render the form
        get("/", (req, res) -> {
            return "<form action='/' method='post'>" +
                    "Enter the city name: <input type='text' name='cityname'>" +
                    "<input type='submit' value='Submit'>" +
                    "</form>";
        });

        // Define a route to handle form submission
        post("/", (req, res) -> {
            String city = req.queryParams("cityname");
            String apiKey = "d94a1a5aa3c285a26a3d45c0e357d771";
            String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;

            try {
                URL url = new URL(apiUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                // Read the response
                StringBuilder response = new StringBuilder();
                try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                }

                // Parse the JSON response
                ObjectMapper mapper = new ObjectMapper();
                JsonNode rootNode = mapper.readTree(response.toString());

                // Check if the response indicates an error
                if (rootNode.has("cod") && rootNode.get("cod").asInt() != 200) {
                    return "Error: " + rootNode.get("message").asText();
                }

                // Extract data from JSON and return
                Manager m1 = new Manager();
                String result = m1.data(rootNode.toString());
                return result;
            } catch (IOException e) {
                e.printStackTrace();
                return "Error fetching temperature information";
            }
        });
    }
}
