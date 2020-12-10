package ee.icd0004.project;

import ee.icd0004.project.api.WeatherApi;
import ee.icd0004.project.api.model.CurrentWeatherData;
import ee.icd0004.project.exception.IllegalMeasurementUnitException;
import ee.icd0004.project.model.CurrentWeatherReport;
import ee.icd0004.project.model.WeatherReport;
import ee.icd0004.project.model.WeatherReportDetails;

public class WeatherTime {
    private final WeatherApi weatherApi;

    public WeatherTime(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }

    public WeatherReport getWeatherReportForCity(String city, String temperatureUnit) {
        weatherApi.setUnits(temperatureUnit);
        return getInitializedWeatherReport(city);
    }

    public WeatherReport getWeatherReportForCity(String city) {
        return getInitializedWeatherReport(city);
    }

    public WeatherReport getInitializedWeatherReport(String city) {
        CurrentWeatherData currentWeatherData = weatherApi.getCurrentWeatherData(city);
        CurrentWeatherReport currentWeatherReport = getInitializedCurrentWeatherReport(currentWeatherData);
        WeatherReportDetails weatherReportDetails = getInitializedWeatherReportDetails(currentWeatherData);

        WeatherReport weatherReport = new WeatherReport();
        weatherReport.setCurrentWeatherReport(currentWeatherReport);
        weatherReport.setWeatherReportDetails(weatherReportDetails);

        return weatherReport;
    }

    private WeatherReportDetails getInitializedWeatherReportDetails(CurrentWeatherData currentWeatherData) {
        WeatherReportDetails weatherReportDetails = new WeatherReportDetails();
        weatherReportDetails.setCity(currentWeatherData.getName());
        weatherReportDetails.setCoordinates(currentWeatherData.getCoord());
        try {
            weatherReportDetails.setTemperatureUnit(weatherApi.getUnits());
        } catch (IllegalMeasurementUnitException e) {
            e.printStackTrace();
        }
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
