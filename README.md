# Weather App

This is a simple Java application that retrieves and displays the current temperature of a given city using the OpenWeatherMap API.

## How to Use
Use an IDE like IntelliJ or Nebeans and build the project using maven.
Then run the **Weather.java** file within ***src/main/java/org/example/*** .
Open a browser window and type the following url ```http://localhost:8080/```.
Type your desired city location within the field specified and click the button.
The application will fetch the current temperature for the entered city and display it in degrees Celsius.

## Dependencies
This project relies on the following:

__Java 8 or higher__
* Internet connection to fetch data from the OpenWeatherMap API

__API Key__
* To use the OpenWeatherMap API, you need to obtain an API key. The key used in this project is provided as a variable apiKey in the Weather class. You should replace it with your own API key.

__Libraries__
* Jackson library is used for handling JSON 
* Spark framework is used for building the REST API and displaying output on a webpage
* OpenCSV to write data to a CSV file
* Java's built in libraries 


Contributors:

<a href="https://github.com/pixelpip/proj/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=pixelpip/proj" />
</a>

Made with [contrib.rocks](https://contrib.rocks).





