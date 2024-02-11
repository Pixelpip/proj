import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Weather{

    public static void main(String[] args) {
        String apiKey = "d94a1a5aa3c285a26a3d45c0e357d771";
        Scanner scan=new Scanner(System.in);
        System.out.println("enter the city you want to know the weather of:");

        String city = scan.nextLine();
        String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            connection.disconnect();

            // Parse the JSON response to get the temperature
            String jsonResponse = response.toString();
            double temperature = parseTemperature(jsonResponse) -273.15;  //Temperature is obtained in Kelvin and has been converted to Celsius

            System.out.printf("Current Temperature in %s: %.2f degrees Celsius\n", city, temperature);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double parseTemperature(String jsonResponse) {
    
        int startIndex = jsonResponse.indexOf("\"temp\":") + 7;
        int endIndex = jsonResponse.indexOf(",", startIndex);

        String temperatureString = jsonResponse.substring(startIndex, endIndex);
        return Double.parseDouble(temperatureString);
    }
}
