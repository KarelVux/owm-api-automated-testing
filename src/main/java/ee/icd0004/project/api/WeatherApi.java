package ee.icd0004.project.api;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import ee.icd0004.project.api.model.CurrentWeatherData;
import ee.icd0004.project.api.model.ForecastData;
import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;

import static com.sun.jersey.api.client.Client.create;
import static com.sun.jersey.api.json.JSONConfiguration.FEATURE_POJO_MAPPING;

public class WeatherApi {
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    private static final String API_KEY = "3a67da1c6356383a2537495317e64315";
    @Setter
    @Getter
    private  String units = "metric";

    public CurrentWeatherData getCurrentWeatherData(String city) {
        // https://openweathermap.org/current
        String resourceUrl = BASE_URL + "/weather";
        ClientResponse response = getOwmApiConnectionData(city, resourceUrl);

        return response.getEntity(CurrentWeatherData.class);
    }


    private static Client getConfiguredClient() {
        ClientConfig configuration = new DefaultClientConfig();
        configuration.getClasses().add(JacksonJaxbJsonProvider.class);
        configuration.getFeatures().put(FEATURE_POJO_MAPPING, true);
        return create(configuration);
    }

    public ForecastData get5DayForecastWeatherData(String city) {
        // https://openweathermap.org/forecast5
        String resourceUrl = BASE_URL + "/forecast";
        ClientResponse response = getOwmApiConnectionData(city, resourceUrl);

        return response.getEntity(ForecastData.class);
    }

    private ClientResponse getOwmApiConnectionData(String city, String resourceUrl) {
        Client client = getConfiguredClient();
        client.setConnectTimeout(5000);
        return client.resource(resourceUrl)
                .queryParam("q", city)
                .queryParam("appId", API_KEY)
                .queryParam("units", units)
                .get(ClientResponse.class);
    }
}
