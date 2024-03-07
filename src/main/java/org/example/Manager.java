package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

public class Manager {
    public static String data(String text) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonArrayNode = objectMapper.readTree(text);
        JsonNode main = jsonArrayNode.get("main");
        double tempC = main.get("temp").asDouble() - 273.15;
        JsonNode sys = jsonArrayNode.get("sys");
        String cityName = jsonArrayNode.get("name").asText();
        String country = sys.get("country").asText();
        String res = String.format("%.2f", tempC) + " at " + cityName + "," + country;
        writeDataToCSV(tempC, cityName, country);
        return res;
    }

    private static void writeDataToCSV(double tempC, String cityName, String country) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter("weather_data.csv", true))) {
            String[] data = {String.format("%.2f", tempC), cityName, country};
            writer.writeNext(data);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("Error writing data to CSV");
        }
    }
}
