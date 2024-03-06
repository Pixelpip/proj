package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.*;

import java.io.*;
import java.nio.file.*;
import org.apache.commons.io.FileUtils;
import org.json.*;



class Manager {
        public static String data(String text) throws Exception {
            ObjectMapper objectMapper = new ObjectMapper(); //Instance of ObjectMapper class to convert JSON to java Object

                //refer to the json.html file in old-files to see a sample output of the json receieved after the api call
                JsonNode jsonArrayNode = objectMapper.readTree(text);
                JsonNode main = jsonArrayNode.get("main");
                double tempC = main.get("temp").asDouble()- 273.15;
                JsonNode sys=jsonArrayNode.get("sys");
                String res=String.format("%.2f",tempC)+" at "+jsonArrayNode.get("name")+","+sys.get("country");
                writeDataToCSV(tempC, jsonArrayNode.get("name").toString() , sys.get("country").toString());

            return res;

        }
    private static void writeDataToCSV(double tempC, String cityName, String country) {
        try {
            // Append to the CSV file
            CSVWriter writer = new CSVWriter(new FileWriter("weather_data.csv", true));
            String[] data = {String.format("%.2f",String.valueOf(tempC)), cityName, country};
            writer.writeNext(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error writing data to CSV");
        }
    }
    }
