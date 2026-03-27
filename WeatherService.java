import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class WeatherService
{
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

    public String getWeather(String city) throws Exception
    {
        String apiKey = System.getenv("WEATHER_API_KEY");

        if (apiKey == null || apiKey.isEmpty())
        {
            throw new Exception ("Api key is either invalid or empty, kindly recheck.");
        }

        String url = BASE_URL + "?q=" + city + "&appid=" + apiKey + "&units=metric";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 404)
        {
            throw new Exception("this " + city + " city not found");
        }
        else if (response.statusCode() == 200)
        {
            throw new Exception("An error has occured, server side issue.");
        }

        return response.body();
    }
}
