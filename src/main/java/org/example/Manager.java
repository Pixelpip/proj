package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

class Manager {
        public static String data(String text) {
            ObjectMapper objectMapper = new ObjectMapper(); //Instance of ObjectMapper class to convert JSON to java Object
            try {
                JsonNode jsonArrayNode = objectMapper.readTree(text);
                JsonNode main = jsonArrayNode.get("main");
                double tempC = main.get("temp").asDouble()- 273.15;
                JsonNode sys=jsonArrayNode.get("sys");
                String res=String.format("%.2f",tempC)+" at "+jsonArrayNode.get("name")+","+sys.get("country");
                return res;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "not working ";
        }
    }
