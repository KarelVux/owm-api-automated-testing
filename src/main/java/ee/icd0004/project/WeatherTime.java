package ee.icd0004.project;

import ee.icd0004.project.api.WeatherApi;
import ee.icd0004.project.api.model.CurrentWeatherData;
import ee.icd0004.project.model.CurrentWeatherReport;
import ee.icd0004.project.model.WeatherReport;
import ee.icd0004.project.model.WeatherReportDetails;
import lombok.Setter;

public class WeatherTime {
    private final WeatherApi weatherApi;
    @Setter
    private String units = "Metric";

    public WeatherTime(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }

    public WeatherReport getWeatherReportForCity(String city, String temperatureUnit) {
        return getInitializedWeatherReport(city, temperatureUnit);
    }

    public WeatherReport getWeatherReportForCity(String city) {
        return getInitializedWeatherReport(city, units);
    }

    public WeatherReport getInitializedWeatherReport(String city, String temperatureUnit) {
        weatherApi.setUnits(temperatureUnit);
        CurrentWeatherData currentWeatherData = weatherApi.getCurrentWeatherData(city);
        CurrentWeatherReport currentWeatherReport = getInitializedCurrentWeatherReport(currentWeatherData);
        WeatherReportDetails weatherReportDetails = getInitializedWeatherReportDetails(currentWeatherData, temperatureUnit);

        WeatherReport weatherReport = new WeatherReport();
        weatherReport.setCurrentWeatherReport(currentWeatherReport);
        weatherReport.setWeatherReportDetails(weatherReportDetails);

        return weatherReport;
    }

    private WeatherReportDetails getInitializedWeatherReportDetails(CurrentWeatherData currentWeatherData, String temperatureUnit) {
        WeatherReportDetails weatherReportDetails = new WeatherReportDetails();
        weatherReportDetails.setCity(currentWeatherData.getName());
        weatherReportDetails.setCoordinates(currentWeatherData.getCoord());
        weatherReportDetails.setTemperatureUnit(temperatureUnit);
        return weatherReportDetails;
    }

    private CurrentWeatherReport getInitializedCurrentWeatherReport(CurrentWeatherData currentWeatherData) {
        CurrentWeatherReport currentWeatherReport = new CurrentWeatherReport();
        currentWeatherReport.setDate(currentWeatherData.getDt());
        currentWeatherReport.setHumidity(currentWeatherData.getMain().getHumidity());
        currentWeatherReport.setPressure(currentWeatherData.getMain().getPressure());
        currentWeatherReport.setTemperature(currentWeatherData.getMain().getTemp());
        return currentWeatherReport;
    }
}
