package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

class Manager {
        public static String data(String text) {
            ObjectMapper objectMapper = new ObjectMapper(); //Instance of ObjectMapper class to convert JSON to java Object
            try {
                JsonNode jsonArrayNode = objectMapper.readTree(text);
                JsonNode jsonNode = jsonArrayNode.get("main");
                double tempC = jsonNode.get("temp").asDouble()- 273.15;
                String res=String.format("%.2f",tempC)+" at "+jsonArrayNode.get("name")+","+jsonArrayNode.get("country");
                return res;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "not working ";
        }
    }
