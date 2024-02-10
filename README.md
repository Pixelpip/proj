# Weather App

This is a simple Java application that retrieves and displays the current temperature of a given city using the OpenWeatherMap API.

## How to Use
Compile the *Weather.java* file & run the *Weather.class* file.
Enter the name of the city you want to know the weather for when prompted.

The application will fetch the current temperature for the entered city and display it in degrees Celsius.
## Dependencies
This project relies on the following:

_Java 8 or higher_
Internet connection to fetch data from the OpenWeatherMap API
_API Key_
To use the OpenWeatherMap API, you need to obtain an API key. The key used in this project is provided as a variable apiKey in the Weather class. You should replace it with your own API key.

_Libraries_
This project does not use any external libraries for JSON parsing. However, for more robust handling of JSON data, you may consider using a JSON parsing library like Gson or Jackson.

_Limitations_
The application's JSON parsing is simplistic and may not handle all possible responses from the OpenWeatherMap API. For production use, consider using a proper JSON parsing library.
Error handling is minimal. The application simply prints stack traces if any exception occurs during the execution.




