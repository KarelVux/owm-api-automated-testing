1. Get data from OWM api
2. Weather report should contain current weather report data
3. Current weather report should return date in correct format when given unix timestamp
4. Weather report should contain weather report detail data (main details data)
5. Coordinates in WeatherReportDetails class must be in format lat, log. Example: "59.44,24.75"
6. Weather report measurement data should be in imperial
7. WeatherReportDetails class will throw error, when temperature unit is not in allowed measurement unit list 
8. WeatherReport should contain weather report main details
9. WeatherApi should get connection from owm api's forecast data
10. WeatherReport should contain forecast data with initialized fields
11. DailyWeather should return date in correct format when given unix timestamp
12. ForecastReport daily weather data should be in ascending order
13. ForecastModeler should not return current date in forecast list